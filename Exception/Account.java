package com.company;

public class Account
{
    int balance;
    Account()
    {
        this.balance = 500;
    }
    void deposit (int amount, String currencyType)
    {
        try {
            if (currencyType.equals("OLD")&&amount>5000)
                throw new DemonetizationException(amount);
            else
                balance += amount;
        }
        catch (DemonetizationException d)
        {
            System.out.println (d);
        }
    }
    void currBalance ()
    {
        System.out.println ("Current balance: "+balance);
    }
    void withdraw (int amount)
    {
        if (balance-amount < 500)
            System.out.println ("Invalid withdrawal - minimum balance not maintained!");
        else
            balance -= amount;
    }
}
