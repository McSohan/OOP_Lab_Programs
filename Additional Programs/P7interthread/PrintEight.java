package com.company;

public class PrintEight implements Runnable {
    PrintNumber pn;
    int i = 0;
    Thread t;
    PrintEight(PrintNumber p)
    {
        pn = p;
        t = new Thread (this);
        t.start();
    }
    public void run()
    {
        while (i++ < 10)
            pn.putMultiple8(8*i);
    }
}
