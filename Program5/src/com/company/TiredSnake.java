package com.company;

public class TiredSnake implements TiredAnimal
{
    boolean hunger;
    TiredSnake()
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
        System.out.println("I am a ssss..Snake and I eat mice");
    }
    public void sound()
    {
        System.out.println("Hiss -  tired!!");
    }
    public void feel() {System.out.println ("I feel very tired hiss");}
}
