package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Wanderer extends Enemy{
    private static final int NUMITERATIONS = 5;
    Direction direction;
    private static final double MOVEMENT = 10;
    Paint color = Color.BLACK;
    int counter = NUMITERATIONS;

    public Wanderer() {
        super();
        super.setFill(color);
        setDirection(random.nextInt(7));

    }

    void checkMovement() {
        if (counter == 1) {
            counter = NUMITERATIONS;
            setDirection(random.nextInt(7));
        }else{
            counter--;
        }
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

    void movement(){
        checkMovement();
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
        }

    }
}
