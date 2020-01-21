package com.company;

import java.util.Scanner;

public class Main {

    public static Address getAddress ()
    {
        int street_num;
        String city, state, country;
        Address addr;
        Scanner Saddr = new Scanner (System.in);
        System.out.print ("Enter Street number: ");
        street_num = Saddr.nextInt();
        System.out.print ("Enter name of the City: ");
        city = Saddr.next();
        System.out.print ("Enter name of the State: ");
        state= Saddr.next();
        System.out.print ("Enter name of the Country: ");
        country= Saddr.next();
        addr = new Address( street_num, city, state, country);
        return addr;
    }

    public static Student getStudentInfo ()
    {
        String USN,Name;
        Scanner Sstu = new Scanner (System.in);
        System.out.print ("Enter USN number: ");
        USN = Sstu.next();
        System.out.print ("Enter Name: ");
        Name = Sstu.next();
        Address addr = getAddress();
        Student stu = new Student (USN, Name, addr);
        return stu;
    }

    public static College getCollegeInfo ()
    {
        String Name;
        Scanner Sstu = new Scanner (System.in);
        System.out.print ("Enter Name: ");
        Name = Sstu.next();
        Address addr = getAddress();
        College coll = new College ( Name, addr);
        return coll;
    }

    public static Employee getEmployeeInfo ()
    {
        String EmpID,Name;
        Scanner Semp = new Scanner (System.in);
        System.out.print ("Enter USN number: ");
        EmpID = Semp.next();
        System.out.print ("Enter Name: ");
        Name = Semp.next();
        Address addr = getAddress();
        Employee emp = new Employee (EmpID, Name, addr);
        return emp;
    }
    public static void printStudentinfo (Student stu)
    {
        System.out.println(stu.getUSN()+" "+stu.getName()+" ");
        stu.printAddress();
    }
    public static void printEmployeeinfo (Employee emp)
    {
        System.out.println(emp.getEmpID()+" "+emp.getName()+" ");
        emp.printAddress();
    }
    public static void printCollegeinfo (College coll)
    {
        System.out.println(coll.getName());
        coll.printAddress();
    }

    public static void main(String[] args)
    {
        int n,m;
        Scanner S1 = new Scanner (System.in);
        System.out.println("Enter the number of students and employees");
        n = S1.nextInt();
        m = S1.nextInt();
        Student Stu[] = new Student[n];
        Employee Emp[] = new Employee[m];
        for (int i=0;i<n;i++)
            Stu[i] = getStudentInfo();
        for (int i=0;i<m;i++)
            Emp[i] = getEmployeeInfo();
        for (int i=0;i<n;i++)
            printStudentinfo(Stu[i]);
        for (int i=0;i<m;i++)
            printEmployeeinfo(Emp[i]);
    }
}
