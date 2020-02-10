package com.company;


    public class Lion implements Animal
    {
        boolean hunger;
        Lion()
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
            System.out.println("I am a Lion and I eat deer");
        }
        public void sound()
        {
            System.out.println("Roar!!");
        }
    }



