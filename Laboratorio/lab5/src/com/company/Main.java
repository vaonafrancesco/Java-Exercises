package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    //region dichiarazione di elementi globali
    private static final double PRIMARYSTAGEHEIGHT = 500;
    private static final double PRIMARYSTAGEWIDTH = 500;
    private static final double MOVEMENT = 10;
    Random random = new Random();

    static SecondStage secondWindow = new SecondStage();
    Stage secondStage = new Stage();
    Circle user = new Circle();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        user.setRadius(20);
        user.setFill(Color.ORANGE);

        secondWindow.start(secondStage);
        Group root = new Group(user);
        Scene scene = new Scene(root, PRIMARYSTAGEWIDTH, PRIMARYSTAGEHEIGHT);
        primarystage.setTitle("Escape!");
        primarystage.setScene(scene);
        primarystage.show();
        user.setCenterX(getRandomX(primarystage.getWidth()));
        user.setCenterY(getRandomY(primarystage.getHeight()));

        //region movements

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case UP -> user.setCenterY(user.getCenterY()-MOVEMENT);
                    case DOWN -> user.setCenterY(user.getCenterY()+MOVEMENT);
                    case RIGHT -> user.setCenterX(user.getCenterX()+MOVEMENT);
                    case LEFT -> user.setCenterX(user.getCenterX()-MOVEMENT);
                }
                iteration();
            }
        });

        //endregion
    }

    private double getRandomX(double height) {
        return (double)random.nextInt((int)height);
    }
    private double getRandomY(double width) {
        return (double)random.nextInt((int)width);
    }

}
