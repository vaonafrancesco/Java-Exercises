package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class User extends Ball{
    Paint color = Color.ORANGE;

    public User() {
        super();
        super.setFill(color);
    }
    public void movement(){};
}
