package com.company;

import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Ball extends Circle {

    private static final double RADIUS = 20;

    private static final double PRIMARYSTAGEHEIGHT = 500;
    private static final double PRIMARYSTAGEWIDTH = 500;

    Random random = new Random();
    public Ball() {
        super(RADIUS);
        super.setCenterX(getRandomX(PRIMARYSTAGEHEIGHT));
        super.setCenterY(getRandomY(PRIMARYSTAGEWIDTH));
    }
    private double getRandomX(double height) {
        return random.nextInt((int)height);
    }
    private double getRandomY(double width) {
        return random.nextInt((int)width);
    }

}
