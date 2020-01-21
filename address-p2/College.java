package com.company;

import java.util.Scanner;

public class College
{
    String Name;
    Address addr;
    //object as a parameter to the constructor
    College( String Name, Address addr)
    {
        this.Name = Name;
        this.addr = addr;
    }

    String getName()
    {
        return Name;
    }
    void printAddress()
    {
        System.out.println (addr.getstreetnum()+" "+addr.getcity()+" "+addr.getstate()+" "+addr.getcountry());
    }
}
