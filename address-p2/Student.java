package com.company;

import java.util.Scanner;

public class Student
{
    String USN,Name;
    Address addr;
    //object as a parameter to the constructor
    Student(String USN, String Name, Address addr)
    {
        this.USN = USN;
        this.Name = Name;
        this.addr = addr;
    }
    String getUSN()
    {
        return USN;
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
