package com.company;

public class DemonetizationException extends Exception
{
    int a;
    DemonetizationException(int a1)
    {
        a = a1;
    }
    @Override
    public String toString()
    {
        return "Deposit of Old Currency of Rs." + a + " crosses Rs.5,000, and cannot be deposited";
    }
}
