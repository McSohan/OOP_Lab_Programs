/*
simple room condition monitoring system for govenment hospital wards
inbuilt rtc usage 
default system settings CCLK = 60MHz and PCLK = 15MHz is assumed
The calculation for Match control register of the timer is also done with the same assumption
*/
#include <lpc214x.h>
#include <stdio.h>
#define SWITCH_ON ((IO0PIN&(1<<30))==0)

typedef struct 
{
	unsigned char sec;//SEC
	unsigned char min;//MIN
	unsigned char hour;//HOUR
	unsigned char month;//MONTH
	unsigned char monthDay;//DOM
	unsigned int year;//YEAR
}rtc_t;

unsigned char timerset = 0;
unsigned char buzz = 0;

__irq void Timer0_ISR()
{
	//when the timer ends, get ready to buzz the buzzer
	buzz = 1;
	T0IR = 0x01;
	VICVectAddr = 0x00000000;//denotes the end of interrupt
}

void DCmotor (int dutycycle);

void uart0_init (void);

void delaybuzz(void);	

void RTC_init (void);

void RTC_setDateTime (rtc_t* rtc);

void RTC_getDateTime (rtc_t* rtc);

int readProxSensor(void);

void print_UART (char *buffer);

int main ()
{
	rtc_t rtc;
	//unsigned char  i, ch;
	char buffer[150];
	int prox_result, temp;
	RTC_init();
	uart0_init();
	IO0DIR |= (1U<<5) | (1U<<31);//P0.5 for the buzzer output and P0.31 for the LED output
	//comment this after the first use - set the time whn the program is burned for the first time
	rtc.sec = 00;
	rtc.min = 00;
	rtc.hour = 20;
	rtc.month = 04;
	rtc.monthDay = 19;
	rtc.year = 2020;
	RTC_setDateTime(&rtc);//comment after first use
	//T0TCR = 0x00;//stop the timer
	T0MCR = 0x07;//interrupts are enabled and stop counter and reset
	T0MR0 = 45000000; //set the match register
	//T0TC = 0x0; //clear the timer counter
	//classify the interrupt
	VICIntEnable = 1<<4;//enable the 4th interrupt - corresponds to the timer T0
	//by default the interrupts are IRQ - select a slot - say 4
	VICVectAddr4 = (unsigned long)Timer0_ISR;
	VICVectCntl4 = 0x24;
	//by default the interrupts are IRQ - select a slot - say 4
	//T0TCR = 0x01;//start the timer
	
	//temperature sensor part
	PINSEL0 |=  3U<<26;   //Select the P0.13 as AD1.4 for ADC function 
	AD1CR =  (1 << 4)  |  (1 << 21) ; //initialize adc 1.4 pin
	while (1)
	{
		//the working code goes here
		AD1CR |=  ( 1 << 24 ) ; //Start conversion
		while( (AD1GDR & (unsigned long) 1 << 31) == 0); //wait for conversion to get over
		temp = (AD1GDR >> 6 ) & 0x3FF; //get the temperature
		if (temp<200 )//if the temp was too hot
		{
			DCmotor(100);//run the motor at full speed
			if(!SWITCH_ON){//if the situation has not been tended to
			//turn on the buzzer and the light
			IO0SET=1<<5; 			// Set the buzzer pin
			delaybuzz(); 				// hault for sometime
			IO0CLR=1<<5; 			//clear the buzzer pin
			IO0CLR = 1U<<31;		//Turn the light on
			}
		}
		else if (temp<400)//if the room is hot
			DCmotor(80); //run the motor at half the speed
		else if (temp<600)//if the room is moderately hot
			DCmotor(50); //run the motor at half the speed
		else 
			//stop the DCmotor
			DCmotor(0);
		RTC_getDateTime (&rtc);
		prox_result = 50 - (30*temp)/1024;//highest = 50, lowest = 20
		sprintf ((char*)buffer,"time:%02d:%02d:%02d date:%d/%02d/%4d\ntemp:%ddeg\n",rtc.hour,rtc.min,rtc.sec,rtc.monthDay, rtc.month, rtc.year, prox_result);
		//this is the uart code for outputting any value
		print_UART((char*)buffer);
		prox_result = readProxSensor();
		if (!prox_result)//if door is closed
		{
			T0TCR = 0x00;//stop the timer
			timerset = 0;
		}
		else //if the door is open
		{
			if (timerset == 0)//if timer is not set
			{
				T0TCR = 0x01;//start the timer
				buzz = 0;
				timerset = 1;
			}
			else if (buzz == 1)
			{
				buzz = 0;
				sprintf ((char*)buffer,"door open for >3sec\n");
				print_UART((char*)buffer);
				//ring the buzzer here
				IO0SET=1<<5; 			// Set the buzzer pin
				delaybuzz(); 				// hault for sometime
				IO0CLR=1<<5; 			//clear the buzzer pin
				timerset = 0;
			}
		}
		if (SWITCH_ON)
			IO0SET = 1U<<31;		//Turn the light off
	}//end of working code - infinite loop
	
}

void print_UART (char *buffer)
{
	unsigned char ch, i;
	i = 0;
	while ((ch=buffer[i++])!='\0')
		{
			while ((U0LSR &(1U<<5)) == 0x00);//wait untill its not ready to recieve
			U0THR = ch; //write the character to the trasmission holding register
		}
}

void RTC_init()
{
	CCR = (1<<0|1<<4);//clock control register
	//enable the rtc and then select the external clock
}

void RTC_setDateTime (rtc_t* rtc)
{
	SEC = rtc->sec;
	MIN = rtc->min;
	HOUR = rtc->hour;
	MONTH = rtc->month;
	DOM = rtc->monthDay;
	YEAR = rtc->year;
}

void RTC_getDateTime (rtc_t* rtc)
{
	rtc->sec = SEC;
	rtc->min = MIN;
	rtc->hour = HOUR;
	rtc->month = MONTH;
	rtc->monthDay = DOM;
	rtc->year = YEAR;
}

void uart0_init ()
{
	//set the 1st alternate functionality for the p0.0 and p0.1 pins
	PINSEL0 |= 0x00000005;
	//wordlength = 8 bits and the divisor latch is to be accessed
	U0LCR = 0x83; //	byte sized register
	U0DLL = 0x08; //  115200 baudrate
	U0DLM = 0x00;
	//AFTER WRITING THE DLL:DLM FOR BAUDRATE, SET UP FOR TX AND RX OPERATIONS
	U0LCR = 0x03;
	//TEST 5th bit of LSR to check if ready to transmit
	//FIFO control register bits: 0 - enable, 1 - Rx reset, 2 - Tx reset
	U0FCR = 0x07;
}

int readProxSensor()//active low output device
{
	int result;
	//enable the sensor
	IO1DIR |= 1<<24; //enable the direction
	IO1CLR |= 1<<24; //enable the sensor logic P1.24 = 0
	result = IO1PIN & (1<<23);
	IO1SET = 1<<24; //disable the sensor logic
	return result;
}

void delaybuzz() 			// delay function declaration
{					
	for(int i=0;i<10;i++)
		for(int j=0;j<100;j++);
}

void DCmotor (int dutycycle)
{
	//P0.28 is assumed to be direction control, assmed to be clockwise by default (pin=0)
	IO0DIR |= 1U<<28;
	PINSEL0 |= 2<<18; //select P0.9 as PWM6
	if (dutycycle == 0)
		PWMTCR = 0;//disable the motor(PWM), ie. turn it off, Stop the timer
	else{
		PWMPCR = 1<<14; //enale PWM6
		PWMMR0 = 1000; //adjusting the pule period
		PWMMR6 = (10*dutycycle); // set the pulse width
		PWMTCR = 0x09;//enable PWM and also start timer
		PWMLER = 0x70; //load the new values into MMR0 amd MMR6
	}
}
