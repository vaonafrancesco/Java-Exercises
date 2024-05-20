package com.company;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    //region dichiarazione di elementi globali
    private static final double PRIMARYSTAGEHEIGHT = 500;
    private static final double PRIMARYSTAGEWIDTH = 500;
    private static final double MOVEMENT = 10;
    private static final double RADIUS = 20;

    static SecondStage secondWindow = new SecondStage();
    Stage secondStage = new Stage();
    //Circle user = new Circle();
    Ball user = new User();
    Ball bubbler = new Bubbler();
    Ball striker = new Striker();
    Ball wanderer = new Wanderer();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {



        secondWindow.start(secondStage);
        Group root = new Group();
        Scene scene = new Scene(root, PRIMARYSTAGEWIDTH, PRIMARYSTAGEHEIGHT);
        primarystage.setTitle("Escape!");
        primarystage.setScene(scene);
        primarystage.show();

        root.getChildren().addAll(user, bubbler, striker, wanderer);


        //region movements

        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP -> {
                        user.setCenterY(user.getCenterY() - MOVEMENT);
                        checkPosition(user, scene);
                    }
                    case DOWN -> {
                        user.setCenterY(user.getCenterY() + MOVEMENT);
                        checkPosition(user, scene);
                    }
                    case RIGHT -> {
                        user.setCenterX(user.getCenterX() + MOVEMENT);
                        checkPosition(user, scene);
                    }
                    case LEFT -> {
                        user.setCenterX(user.getCenterX() - MOVEMENT);
                        checkPosition(user, scene);
                    }
                }
            }
        });


        //endregion
    }

    private void checkPosition(Circle element, Scene scene) {
        double centerX = element.getCenterX();
        double centerY = element.getCenterY();

        if (centerX < 0) {
            element.setCenterX(centerX + scene.getWidth());

        }else if(centerX > scene.getWidth()){
            element.setCenterX(scene.getX());

        }else if (centerY < 0) {
            element.setCenterY(centerY + scene.getHeight());

        }else if(centerY > scene.getHeight()){
            element.setCenterY(centerY - scene.getHeight());
        }

    }



}
