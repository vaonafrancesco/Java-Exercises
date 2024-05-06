package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        //Text t = new Text(50, 100, "AAAAAAAAAAAA");
        //crea un text con scritto ciao
        Text t = new Text();



        Group g = new Group(t);


        primarystage.setTitle("Hello World");
        primarystage.setScene(new Scene(root, 300, 275));
        primarystage.show();
    }
}
