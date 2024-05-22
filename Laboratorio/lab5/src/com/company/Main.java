package com.company;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
    private static boolean GAMEOVER = false;
    Random random = new Random();
    int counter = NEWBALL;
    ArrayList<Ball> balls = new ArrayList<>();

    static SecondStage secondWindow = new SecondStage();
    Stage secondStage = new Stage();
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
                if (!GAMEOVER) {
                    checkNewBall();
                    switch (keyEvent.getCode()) {
                        case UP -> {
                            user.setCenterY(user.getCenterY() - MOVEMENT);
                            iteration();
                        }
                        case DOWN -> {
                            user.setCenterY(user.getCenterY() + MOVEMENT);
                            iteration();
                        }
                        case RIGHT -> {
                            user.setCenterX(user.getCenterX() + MOVEMENT);
                            iteration();
                        }
                        case LEFT -> {
                            user.setCenterX(user.getCenterX() - MOVEMENT);
                            iteration();
                        }
                    }
                }
            }
        });


        //endregion
    }

    private void checkCollision() {
        for(Ball b : balls){
            if (checkDistance(b, user)) {
                GAMEOVER = true;
                secondWindow.setGameOver();
            }
        }
    }

    private boolean checkDistance(Ball b, Ball user) {
        double ballX, ballY, userX, userY;
        ballX = b.getCenterX();
        ballY = b.getCenterY();
        userX = user.getCenterX();
        userY = user.getCenterY();
        if(Math.sqrt((Math.pow(ballX-userX, 2)+ Math.pow(ballY-userY, 2)))<=b.getRadius()+RADIUS){
            b.setFill(Color.RED);
            user.setFill(Color.RED);
            return true;
        };
        return false;
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

    private void iteration() {
        for (Ball b : balls){
            b.movement();
            user.checkPosition();
            b.checkPosition();
            checkCollision();
        }
        secondWindow.setScore();
    }

}
