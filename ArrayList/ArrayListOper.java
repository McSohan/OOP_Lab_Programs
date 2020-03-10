package com.company;

import java.util.ArrayList;

public class ArrayListOper {
    ArrayList<String> a;
    ArrayListOper()
    {
        a = new ArrayList<String>();
    }
    void add(String s)
    {
        a.add(s);
    }
    String[] toArray()
    {
        return (String[]) a.toArray();
    }
    void reverse()
    {
        //to reverse the array list
        for (int i = 0;i<a.size();i++)
            a.add(a.remove(0));
    }
    String[] subList(int from, int to) throws ArrayIndexOutOfBoundsException
    {
        if (from<0||to<0||from>=a.size()||to>=a.size())
            throw new ArrayIndexOutOfBoundsException();
        return (String[]) a.subList(from, to).toArray();
    }
    ArrayList<String> shallowCopy()
    {
        return (ArrayList<String>)a.clone();
    }
}
