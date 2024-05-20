package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Striker extends Enemy{
    Direction direction;
    private static final double MOVEMENT = 10;
    Random random = new Random();
    Paint color = Color.BLUE;

    public Striker() {
        super();
        super.setFill(color);
        setDirection(random.nextInt(2));
    }

    public void setDirection(int num) {
        this.direction = direction;
    }

    @Override
    void movement() {

    }
}
