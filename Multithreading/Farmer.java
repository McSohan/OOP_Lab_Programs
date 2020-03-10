package com.company;
import java.util.ArrayList;

public class Farmer extends Thread {
    ArrayList<String> fruits;
    int farmernumber;
    Market mymarket;

    Farmer(Market m, int farmernumber) {

        mymarket = m;
        this.farmernumber = farmernumber;
        fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Watermelon");
        this.start();
    }

    public void run() {
        System.out.println ("Starting farmer "+farmernumber);
        for (String s : fruits) {
            mymarket.farmer(s);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
