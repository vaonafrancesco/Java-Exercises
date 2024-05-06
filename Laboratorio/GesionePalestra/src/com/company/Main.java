package com.company;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {
    //region Buttons, spacing
    Button tutti = new Button("Tutti");
    Button studenti = new Button("Studenti");
    Button atleti = new Button("Atleti");
    Button perNome = new Button("Per nome");
    Button perEta = new Button("Per eta");
    Button exit = new Button("Exit");
    final int SPACING = 10;
    //endregion

    List<Persona> persone = new LinkedList<Persona>();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primarystage) throws Exception{

        //manca da centrare i bottoni nel verde nel topAP
        //region BorderPane

        //BorderPane
        BorderPane bp = new BorderPane();

        //region topAP

        //create AnchorPane
        AnchorPane topAP = new AnchorPane();
        //color AnchorPane
        topAP.setBackground(new Background(
                new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        topAP.setPrefSize(30, 30);

        //region HBOX in topAP
        //Left
        HBox topLeftHB = new HBox();
        topLeftHB.getChildren().addAll( tutti, studenti, atleti);
        topLeftHB.setSpacing(SPACING);

        //Right
        HBox topRightHB = new HBox();
        topRightHB.getChildren().addAll( perNome, perEta);
        topRightHB.setSpacing(SPACING);
        //endregion

        AnchorPane.setLeftAnchor(topLeftHB, 10.0);
        AnchorPane.setRightAnchor(topRightHB, 10.0);

        topAP.getChildren().add(topLeftHB);
        topAP.getChildren().add(topRightHB);


        //endregion

        //region center

        Text text = new Text("Benvenuto nella gestione della palestra");

        //endregion

        //region bottomAP

        AnchorPane bottomAP = new AnchorPane();

        //region bottomRightHB
        HBox bottomRightHB = new HBox();
        bottomRightHB.setSpacing(10);
        bottomRightHB.getChildren().add(exit);
        //endregion

        bottomAP.getChildren().add(bottomRightHB);
        AnchorPane.setRightAnchor(bottomRightHB, 10.0);

        //endregion

        //border pain settings
        bp.setTop(topAP);
        bp.setCenter(text);
        bp.setBottom(bottomAP);

        //endregion

        //region HandlerButtons

        //here code for Handling of Buttons


        //endregion


        //main settings
        primarystage.setTitle("Gestione Palestra");
        Scene scene = new Scene(bp, 500, 250);
        primarystage.setScene(scene);
        primarystage.show();
    }

    public Main() {
        persone.add(new Persona("Mario", "Rossi", "1", 1950));
        //tutto come riga sopra
        persone.add(new Persona( "Carla", "Rossi", "2", 1990));
        persone.add(new Studente( "Giovanni", "Bianchi", "3", 1995, "UNITN", Studente.Laurea.TRIENNALE));
        persone.add(new Studente("Anna", "Bianchi", "4", 1990, "UNIPD", Studente.Laurea.MAGISTRALE));
        persone.add(new Atleta("Giacomo", "Verdi", "5", 1991, "nuoto", Atleta.Rilevanza.NAZIONALE));
        persone.add(new Atleta("Alice", "Verdi", "6", 1967, "Curling", Atleta.Rilevanza.INTERNAZIONALE));
        persone.add(new StudenteAtleta("Alberto", "Ferrari", "7", 1993, "UNITN", Studente.Laurea.MAGISTRALE, "atletica", IAtleta.Rilevanza.INTERNAZIONALE));
        persone.add(new StudenteAtleta("Vincenzo", "Ferrari", "8", 1997, "UNIVR", Studente.Laurea.TRIENNALE, "atletica", IAtleta.Rilevanza.NAZIONALE));

    }
}
