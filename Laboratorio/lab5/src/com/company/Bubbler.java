package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Bubbler extends Wanderer{
    Direction direction;
    private static final double MOVEMENT = 10;
    Paint color = Color.LIGHTBLUE;
    int count = 0;

    public Bubbler() {
        super();
        super.setFill(color);
    }
}
