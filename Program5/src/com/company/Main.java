package com.company;

public class Main {

    public static void main(String[] args)
    {
	    Lion L= new Lion();
	    Snake S = new Snake();
	    TiredLion TL = new TiredLion();
	    TiredSnake TS = new TiredSnake();
	    L.sound();
	    S.eat();
	    TL.feel();
	    TS.feel();
    }

