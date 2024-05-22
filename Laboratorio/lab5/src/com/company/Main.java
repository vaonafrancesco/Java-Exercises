package com.company;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    //region dichiarazione di elementi globali
    private static final double PRIMARYSTAGEHEIGHT = 500;
    private static final double PRIMARYSTAGEWIDTH = 500;
    private static final double MOVEMENT = 10;
    private static final double RADIUS = 20;
    private static final int NEWBALL = 10;
    Random random = new Random();
    int counter = NEWBALL;
    ArrayList<Ball> balls = new ArrayList<>();

    static SecondStage secondWindow = new SecondStage();
    Stage secondStage = new Stage();
    //Circle user = new Circle();
    Ball user = new User();
    Ball bubbler = new Bubbler();
    Ball striker = new Striker();
    Ball wanderer = new Wanderer();
    Group root = new Group();
    Ball newBall;
    Scene scene = new Scene(root, PRIMARYSTAGEWIDTH, PRIMARYSTAGEHEIGHT);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        //balls.add(user);
        balls.add(bubbler);
        balls.add(striker);
        balls.add(wanderer);

        secondWindow.start(secondStage);

        primarystage.setTitle("Escape!");
        primarystage.setScene(scene);
        primarystage.show();

        root.getChildren().addAll(user, bubbler, striker, wanderer);


        //region movements

        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                checkNewBall();

                switch (keyEvent.getCode()) {
                    case UP -> {
                        user.setCenterY(user.getCenterY() - MOVEMENT);
                        checkPosition(user);
                        movement();
                    }
                    case DOWN -> {
                        user.setCenterY(user.getCenterY() + MOVEMENT);
                        checkPosition(user);
                        movement();
                    }
                    case RIGHT -> {
                        user.setCenterX(user.getCenterX() + MOVEMENT);
                        checkPosition(user);
                        movement();
                    }
                    case LEFT -> {
                        user.setCenterX(user.getCenterX() - MOVEMENT);
                        checkPosition(user);
                        movement();
                    }
                }
            }
        });


        //endregion
    }

    private void checkNewBall() {
        if (counter == 1) {
            counter = NEWBALL;
            switch (random.nextInt(3)) {
                case 0:
                    balls.add(new Striker());
                    break;
                case 1:
                    balls.add(new Wanderer());
                    break;
                case 2:
                    balls.add(new Bubbler());
                    break;
            }
            root.getChildren().add(balls.getLast());
        }else{
            counter--;
        }
    }

    private void movement() {
        for (Ball b : balls){
            b.movement();
            checkPosition(b);
        }
    }

    private void checkPosition(Circle element) {
        double centerX = element.getCenterX();
        double centerY = element.getCenterY();

        if (centerX < 0) {
            element.setCenterX(centerX + PRIMARYSTAGEWIDTH);

        }else if(centerX > PRIMARYSTAGEWIDTH){
            element.setCenterX(centerX - PRIMARYSTAGEWIDTH);

        }else if (centerY < 0) {
            element.setCenterY(centerY + PRIMARYSTAGEHEIGHT);

        }else if(centerY > PRIMARYSTAGEHEIGHT){
            element.setCenterY(centerY - PRIMARYSTAGEHEIGHT);
        }

    }





}
