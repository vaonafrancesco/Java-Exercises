package com.company;

import javafx.scene.paint.Paint;

abstract class Enemy extends Ball {
    double radius;
    Paint color;

    private static final double RADIUS = 20;

    public Enemy() {
        super();
    }

    abstract void movement();
}
