package com.company;

public class PrintSeven implements Runnable {
    PrintNumber pn;
    int i = 0;
    Thread t;
    PrintSeven(PrintNumber p)
    {
        pn = p;
        t = new Thread (this);
        t.start();
    }
    public void run()
    {
        while (i++ < 10)
            pn.putMultiple7(7*i);
    }
}
