package com.company;

public class CollisionException extends Exception{
    String direction;
    CollisionException(int a)
    {
        if (a==1)
            direction = "Clockwise";
        else
            direction = "Anticlockwise";
    }
    public String toString()
    {
        return "Both vehicles are going in "+direction+" direction,\n there is chance of collision!!";
    }
}
