package com.company;

public class PrintNumber {
    int num;
    int turn = 7;
    synchronized void putMultiple7(int a)
    {
        while (turn!=7)
            try{
                wait();
            }catch (InterruptedException ie){
                System.out.println(ie);
            }

        num = a;
        turn = 8;
        System.out.println("7th multiple: "+num);
        notify();
    }
    synchronized void putMultiple8(int a)
    {
        while (turn!=8)
            try{
                wait();
            }catch (InterruptedException ie){
                System.out.println(ie);
            }

        num = a;
        turn = 7;
        System.out.println("8th multiple: "+num);
        notify();
    }
}
