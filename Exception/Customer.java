package com.company;
import java.util.Scanner;

public class Customer {
    String Name;
    Account acc ;
    Customer(String n)
    {
        Name = n;
        acc = new Account();
    }
    void getChoice(int a)
    {
        Scanner s = new Scanner (System.in);
        switch (a)
        {
            case 1: System.out.println ("Enter deposit amount and currency type:");
                    acc.deposit(s.nextInt(),s.next());
                    break;
            case 2:
                    System.out.println ("Enter the amount to be withdrawn:");
                    acc.withdraw(s.nextInt());
                    break;
            case 3: acc.currBalance();
                    break;
            default: System.out.println ("Wrong choice!!");
        }
    }
}
