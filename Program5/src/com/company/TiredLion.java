package com.company;

public class TiredLion implements TiredAnimal
{
    boolean hunger;
    TiredLion()
    {
        hunger = true;
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
        System.out.println("I am a tired Lion and I eat deer");
    }
    public void sound()
    {
        System.out.println("Purr -- tired!!");
    }
    public void feel() {System.out.println ("I feel tiiired");}
}
