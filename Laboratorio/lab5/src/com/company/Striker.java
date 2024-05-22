package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Striker extends Enemy{
    Direction direction;
    private static final double MOVEMENT = 10;

    Paint color = Color.BLUE;

    public Striker() {
        super();
        super.setFill(color);
        setDirection(random.nextInt(7));
    }

    public void setDirection(int num) {
        switch (num){
            case 0: direction = Direction.BOTTOM;
                break;
            case 1: direction = Direction.BOTTOMLEFT;
                break;
            case 2: direction = Direction.BOTTOMRIGHT;
                break;
            case 3: direction = Direction.LEFT;
                break;
            case 4: direction = Direction.RIGHT;
                break;
            case 5: direction = Direction.TOP;
                break;
            case 6: direction = Direction.TOPLEFT;
                break;
            case 7: direction = Direction.TOPRIGHT;
                break;

        }
    }

    @Override
    void movement() {
        switch (direction){
            case TOP -> super.setCenterY(super.getCenterY()-MOVEMENT);
            case LEFT -> super.setCenterX(super.getCenterX()-MOVEMENT);
            case RIGHT -> super.setCenterX(super.getCenterX()+MOVEMENT);
            case BOTTOM -> super.setCenterY(super.getCenterY()+MOVEMENT);
            case BOTTOMLEFT -> {
                super.setCenterY(super.getCenterY() + MOVEMENT);
                super.setCenterX(super.getCenterX() - MOVEMENT);
            }
            case BOTTOMRIGHT -> {
                super.setCenterY(super.getCenterY() + MOVEMENT);
                super.setCenterX(super.getCenterX() + MOVEMENT);
            }
            case TOPLEFT -> {
                super.setCenterY(super.getCenterY() - MOVEMENT);
                super.setCenterX(super.getCenterX() - MOVEMENT);
            }
            case TOPRIGHT -> {
                super.setCenterY(super.getCenterY() - MOVEMENT);
                super.setCenterX(super.getCenterX() + MOVEMENT);
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
