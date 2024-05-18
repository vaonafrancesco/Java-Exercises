package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private static final int SPOSTAMENTO = 10;
    final int FIRSTSCENEX = 500;
    final int FIRSTSCENEY = 300;
    final float radius = 50.0f;
    Random random = new Random();
    double posX = (double)FIRSTSCENEX/2;
    double posY = (double)FIRSTSCENEY/2;
    VBox vbox = new VBox(8);
    StackPane root2 = new StackPane(vbox);
    Scene scene2 = new Scene(root2);
    Stage secondStage = new Stage();
    //first circle

    Circle circle = new Circle(posX, posY, radius);
    Circle secondCircle = new Circle(random.nextInt(450), random.nextInt(250), radius);
    Group root = new Group(circle);
    Scene scene = new Scene(root, FIRSTSCENEX, FIRSTSCENEY);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        //region first stage

        //setting first circle information
        circle.setCenterX(secondStage.getWidth()/2);
        circle.setCenterY(secondStage.getHeight()/2);
        circle.setFill(Color.BLUE);

        //setting second circle information
        secondCircle.fillProperty().set(Color.GREEN);

        circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                circle.getCenterX();
                circle.setCenterX(circle.getCenterX()-SPOSTAMENTO);
                setPos(circle.getCenterX(), circle.getCenterY());
                circle.setCenterX(posX);
                circle.setCenterY(posY);
            }
        });
        scene.setOnKeyPressed(keyEvent -> {

            switch (keyEvent.getCode()){
                case I:
                    circle.getCenterY();
                    circle.setCenterY(circle.getCenterY()-SPOSTAMENTO);
                    setPos(circle.getCenterX(), circle.getCenterY());
                    circle.setCenterX(posX);
                    circle.setCenterY(posY);
                    break;
                case K:
                    circle.getCenterY();
                    circle.setCenterY(circle.getCenterY()+SPOSTAMENTO);
                    setPos(circle.getCenterX(), circle.getCenterY());
                    circle.setCenterX(posX);
                    circle.setCenterY(posY);
                    break;
            }
        });

        primarystage.setTitle("Lab 4");
        primarystage.setScene(scene);
        primarystage.show();
        //endregion

//--------------------------------------------------------------------------------------------------//


        //region second stage


        Button moveCircle = new Button("Move Circle 1");
        Button addCircle = new Button("Add Circle");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        reset.setDisable(true);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secondStage.close();
                primarystage.close();
            }
        });


        vbox.getChildren().addAll(moveCircle, addCircle, reset, exit);
        //imposta la seconda finestra che inizi dalla fine della prima
        secondStage.setX(primarystage.getX() + primarystage.getWidth() + 10);

        //region Handling Buttons
        moveCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.getCenterX();
                circle.setCenterX(circle.getCenterX()+SPOSTAMENTO);
                setPos(circle.getCenterX(), circle.getCenterY());
                circle.setCenterX(posX);
                circle.setCenterY(posY);
            }
        });
        addCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.getChildren().add(secondCircle);
                addCircle.setDisable(true);
                reset.setDisable(false);
            }
        });
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                switch (keyEvent.getCode()){
                    case I:
                        circle.getCenterY();
                        circle.setCenterY(circle.getCenterY()-SPOSTAMENTO);
                        setPos(circle.getCenterX(), circle.getCenterY());
                        circle.setCenterX(posX);
                        circle.setCenterY(posY);
                        break;
                    case K:
                        circle.getCenterY();
                        circle.setCenterY(circle.getCenterY()+SPOSTAMENTO);
                        setPos(circle.getCenterX(), circle.getCenterY());
                        circle.setCenterX(posX);
                        circle.setCenterY(posY);
                        break;
                }
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.getChildren().remove(secondCircle);
                addCircle.setDisable(false);
                reset.setDisable(true);
            }
        });


        //endregion

        secondStage.setTitle("Second Stage");

        secondStage.setScene(scene2);
        secondStage.show();
        secondStage.setX(primarystage.getHeight() + primarystage.getX());
        //endregion
    }

    private void setPos(double centerX, double centerY) {
        if (centerX < 0) {
            setPos(scene.getWidth(), centerY);

        }else if(centerX > scene.getWidth()){

            setPos(0, centerY);

        }else if (centerY < 0) {

            setPos(centerX, scene.getHeight());

        }else if(centerY > scene.getHeight()){

            setPos(centerX, 0);

        }else {
            posX = centerX;
            posY = centerY;
        }

    }


}

//secondo cerchio in posizione random nella finestra
//primo cerchio che si adatta alla finestra

//SPOEGAZIONE
/*
  root è un Group
  circle lo creo non nello start ma globale
  circle.setFill(Color.BLUE)
  root.getChildren().add(circle);
  PULSANTI
  allineo: stage2.setX(primaryStage.GetX + prymariStage.getWitdh()) (questo dopo che il prrimarystage è stato visualizzato(.show))
  vbox.setAlignment
  MOVIMENTO DEL CERCHIO
  circle.setOnMouseEntered(MOuseEvent mouseEvent){handle...}
  MOVIMENTO DEL CERCHIO DA TASTIERA
  lo metto sulla scena
  SECONDO CERCHIO
  lo dichiaro nel main come globale come il primo cerchio
  lo inizializzo nell'handler del pulstande addCircle
  uso la classe random per dove crearlo
  aggiungo a root questa cosa
  RESET
  tolgo il secondo cerchio dalla scena e dal group
  COLLISIONI
  controllo per sapere se due cerchi si stanno toccando: i cerchi so toccano se la distanza è meno due volte il raggiook

 */

