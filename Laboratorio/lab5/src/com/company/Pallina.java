package com.company;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Pallina extends Circle {
    double radius;
    Paint color;

    public Pallina(double v, Paint paint) {
        super(v, paint);
        this.radius = v;
        this.color = paint;
    }
}
