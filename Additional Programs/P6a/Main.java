package com.company;
/*
M C Sohan
On a single track two vehicles are running.
As vehicles are going in same direction there is no problem.
If the vehicles are running in different direction there is a chance of collision.
To avoid collisions write a Java program using exception handling. You are free to make necessary assumptions.
 */

import java.util.Scanner;

public class Main {

    public static void checkDirection(int a, int b) throws CollisionException
    {
        if (a==b)
            throw new CollisionException(a);
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner (System.in);
        int a, b;
        do{
            System.out.println("Enter directions of two vehicles,\nor -1 -1 to exit");
            a = sn.nextInt();
            b = sn.nextInt();
            try
            {
                if (a == -1 && b == -1)
                    return;
                checkDirection(a,b);
                System.out.println ("The track is safe");

            }catch (CollisionException ce)
            {   System.out.println (ce);    }
        }while (true);
    }
}
