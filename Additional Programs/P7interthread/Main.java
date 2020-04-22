package com.company;
/*
M C Sohan
Write a Java Program to print the multiples of 7, 8 alternatively to demonstrate the concept of inter-thread communication.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();
        PrintSeven ps = new PrintSeven(pn);
        PrintEight pe = new PrintEight(pn);

        try{
            ps.t.join();
            pe.t.join();
        }catch (InterruptedException ie)
        {
            System.out.println(ie);
        }
        System.out.println ("End.");
    }
}
