package com.company;
import java.util.ArrayList;

public class Market
{
    int fruitsNumber;
    int currentCapacity;
    ArrayList <String> a;
    public Market (int fruitsNumber)
    {
        this.fruitsNumber = fruitsNumber;
        currentCapacity = 0;
        a = new ArrayList<String>();
    }
    //implementing the producer consumer interface
    synchronized boolean isFull()
    {
        if (currentCapacity==fruitsNumber)
            return true;
        return false;
    }
    synchronized boolean isEmpty()
    {
        if (currentCapacity==0)
            return true;
        return false;
    }
    synchronized void farmer (String fruit)
    {
        try {
        if (isFull())
            wait();
        }catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        a.add(fruit);
        currentCapacity++;
        System.out.println ("Farmer"+Thread.currentThread()+"adds- "+fruit);
        notify();
    }
    synchronized String consumer ()
    {
        String s;
        try {
            if (isEmpty())
                wait();
        }catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        currentCapacity--;
        s =  a.remove(0);
        System.out.println ("Customer "+Thread.currentThread()+" consumes "+s);
        return s;
    }

}
