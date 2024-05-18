package com.company;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private static final double RADIUS = 20;
    Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 275);


        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getTarget() instanceof Circle) {
                    root.getChildren().remove(mouseEvent.getTarget());

                }else {
                    if(mouseEvent.isShiftDown()){
                        if (getX(mouseEvent)>RADIUS*2 && getX(mouseEvent) < scene.getWidth()-RADIUS*2 &&  getY(mouseEvent)>RADIUS*2 && getY(mouseEvent) < scene.getHeight()-RADIUS*2) {
                            Circle circle = new Circle(mouseEvent.getSceneX(), mouseEvent.getSceneY(), RADIUS*2 );
                            circle.setFill(Color.rgb(getRandomInt(), getRandomInt(), getRandomInt()));
                            root.getChildren().add(circle);
                        }
                    }else{
                        if (getX(mouseEvent)>RADIUS && getX(mouseEvent) < scene.getWidth()-RADIUS &&  getY(mouseEvent)>RADIUS && getY(mouseEvent) < scene.getHeight()-RADIUS) {
                            Circle circle = new Circle(mouseEvent.getSceneX(), mouseEvent.getSceneY(), RADIUS );
                            circle.setFill(Color.rgb(getRandomInt(), getRandomInt(), getRandomInt()));
                            root.getChildren().add(circle);
                        }
                    }
                }
            }
        });

        primarystage.setTitle("Hello World");
        primarystage.setScene(scene);
        primarystage.show();
    }

    private int getRandomInt() {
        return random.nextInt(255);
    }

    public double getX(MouseEvent mouseEvent) {
        return mouseEvent.getSceneX();
    }


    public double getY(MouseEvent mouseEvent) {
        return mouseEvent.getSceneY();
    }


    
}
