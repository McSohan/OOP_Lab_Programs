package com.company;

public class Employee
{
    String EmpID,Name;
    Address addr;
    //object as a parameter to the constructor
    Employee(String EmpID, String Name, Address addr)
    {
        this.EmpID = EmpID;
        this.Name = Name;
        this.addr = addr;
    }
    String getEmpID()
    {
        return EmpID;
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
