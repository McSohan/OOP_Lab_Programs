package com.company;
import java.util.Scanner;

public class Main
{
    static int reverseIntDigits (int y)
    {
        int x = 0;
        while (y > 0)
        {
            x = x*10 + y%10;
            y = y/10;
        }
        return x;
    }
    static performOperation checkEvenOdd()
    {
        return (x->(x%2)!=0);
    }
    static performOperation checkPrime()
    {
        return (x ->{
            int s = (int)Math.sqrt(x) +1;
            for (int i=2;i<s;i++)
                if (x%i == 0)
                    return false;
        return true;
        });
    }
    static performOperation checkPallindrome()
    {
        return (x -> {
            int m = reverseIntDigits(x);
            return (x == m);
    });
    }
    static boolean operate (performOperation p,int a)
    {
        return p.operation(a);
    }
    public static void main (String args[])
    {
        int choice, num;
        performOperation op;
        Scanner sn = new Scanner (System.in);
        do{
        System.out.println("Enter choice\n1.is odd?\n2.is prime?\n3.is palindrome?");
        choice = sn.nextInt();
        System.out.println("Enter the positive number to be checked");
        num = sn.nextInt();
        }while (choice<1||choice>3||num<0);
        switch (choice)
        {
            case 1:
                System.out.println (operate (checkEvenOdd(),num));
                break;
            case 2:
                System.out.println (operate (checkPrime(),num));
                break;
            case 3:
                System.out.println (operate (checkPallindrome(),num));
                break;
            default: System.out.println ("Somethings wrong I can feel it");
                break;
        }
    }
}
