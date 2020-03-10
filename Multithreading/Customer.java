package com.company;

public class Customer extends Thread{
    int customernumber;
    Market mymarket;
    Customer(int customernumber, Market m)
    {
        this.customernumber = customernumber;
        mymarket = m;
        this.start();
    }
    public void run() {
        System.out.println ("Starting customer "+customernumber);
        for (int i =0;i<3;i++)
        {
            String s = mymarket.consumer();
           // System.out.println ("Customer "+customernumber+" consumes- "+s);
            try {
                sleep(2);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }
}
