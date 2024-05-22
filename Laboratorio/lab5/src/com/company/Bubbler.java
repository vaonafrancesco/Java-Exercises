package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Bubbler extends Wanderer{
    private static final double INCREMENTRADIUS = 0.2;
    Direction direction;
    private static final double MOVEMENT = 10;
    Paint color = Color.LIGHTBLUE;
    int count = 0;


    public Bubbler() {
        super();
        super.setFill(color);
    }
    public void movement(){
        if( random.nextInt(9) == 0){
            super.setRadius(super.getRadius() + (super.getRadius() * INCREMENTRADIUS));
        }
        super.movement();
    }
}
