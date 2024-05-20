package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Wanderer extends Enemy{
    Direction direction;
    private static final double MOVEMENT = 10;
    Paint color = Color.BLACK;

    public Wanderer() {
        super();
        super.setFill(color);
    }

    @Override
    void movement() {

    }
}
