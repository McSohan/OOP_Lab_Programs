package com.company;

public class Snake implements Animal
{
    boolean hunger;
    Snake()
    {
        hunger = false;
    }
    public void makeHungry()
    {
        hunger = true;
    }
    public void feed()
    {
        hunger = false;
    }
    public boolean isHungry()
    {
        return hunger;
    }
    public void eat()
    {
        System.out.println("I am a snake and I eat rats");
    }
    public void sound()
    {
        System.out.println("Hiss!");
    }
}

