package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int choice;
        System.out.println ("Enter the name of the customer:");
        Customer C1 = new Customer (s.next());
        while (true) {
            System.out.println("Enter 1 to deposit");
            System.out.println("Enter 2 to withdraw");
            System.out.println("Enter 3 to check current balance");
            System.out.println("Anything else to exit");
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                case 2:
                case 3: C1.getChoice(choice);
                        break;
                default : return;
            }
        }
    }
}
