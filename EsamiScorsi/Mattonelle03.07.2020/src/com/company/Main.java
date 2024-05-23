package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    private static final double LATO = 130, SCENEX = 300, SCENEY = 180;
    private static final double RADIUS = LATO/2;
    Random random = new Random();
    ArrayList<Mattonella> archivio = new ArrayList<>();
    Button prev = new Button("<prev");
    Button next = new Button("next>");
    HBox pulsanti = new HBox(prev, next);
    Text text = new Text();
    VBox vb = new VBox(text, pulsanti);
    Pane pane = new Pane();
    HBox hb = new HBox(vb, pane);
    Scene scene = new Scene(hb, SCENEX, SCENEY);
    public ArrayList<Color> colors = new ArrayList<>();
    Rectangle rectangle = new Rectangle(RADIUS, RADIUS);
    Circle circle = new Circle(RADIUS/2);
    int index = 0, indiceColoreMattonella=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) {

        setColors();
        prev.setDisable(true);
        addFirstElements();
        refresh(archivio.get(index));
        hb.setAlignment(Pos.CENTER);

        pane.setPrefSize(LATO, LATO);
        pane.setMinSize(LATO, LATO);
        pane.setMaxSize(LATO, LATO);

        vb.setSpacing(25);
        vb.setAlignment(Pos.CENTER);


        //region HANDLING BUTTONS

        prev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                index--;
                refresh(archivio.get(index));

                checkVisibility();
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                index++;
                refresh(archivio.get(index));
                checkVisibility();
            }
        });

        //endregion

        //region RIGHT SIDE HBOX

        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(archivio.get(index).sceltaColore){
                    setPaneColor(getNextColor());
                }
            }
        });

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(archivio.get(index).sceltaColore){
                    circle.setFill(getNextColor());
                }
                mouseEvent.consume();
            }
        });
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(archivio.get(index).sceltaColore){
                    rectangle.setFill(getNextColor());
                }
                mouseEvent.consume();
            }
        });
        //endregion

        primarystage.setTitle("Catalogo Piastrelle");
        primarystage.setScene(scene);
        primarystage.show();
    }

    private void refresh(Mattonella mattonella){
        text.setText(mattonella.toString());
        if (mattonella.sceltaColore) {
            indiceColoreMattonella = 0;
            pane.setBackground(new Background(new BackgroundFill(colors.get(indiceColoreMattonella), CornerRadii.EMPTY, Insets.EMPTY)));
        }else{
            setPaneColor(mattonella.color);
        }


        //se la mattonella è di tipo Bicolore allora disegno un cerchio o un quadrato
        if (mattonella instanceof Bicolore) {
            if (((Bicolore) mattonella).interno == Interno.CERCHIO){
                try {
                    pane.getChildren().remove(rectangle);
                    pane.getChildren().remove(circle);
                } catch (Exception ignored){}
                circle.setFill(getColor(mattonella.color));
                circle.setCenterX(pane.getHeight()-2*RADIUS/2);
                circle.setCenterY(pane.getWidth()-2*RADIUS/2);
                pane.getChildren().add(circle);
            }else if (((Bicolore) mattonella).interno == Interno.QUADRATO){
                try {
                    pane.getChildren().remove(circle);
                    pane.getChildren().remove(rectangle);
                } catch (Exception ignored){}
                rectangle.setFill(getColor(mattonella.color));
                rectangle.setX(pane.getHeight()-3*(RADIUS/2));
                rectangle.setY(pane.getWidth()-3*(RADIUS/2));
                pane.getChildren().add(rectangle);
            }
        }else {
            try {
                pane.getChildren().remove(rectangle);
                pane.getChildren().remove(circle);
            } catch (Exception ignored){}

        }

    }
    private Color getColor(Color color) {
        Color tempColor;
        do {
            switch (random.nextInt(6)){
                case 0 -> tempColor = Color.BROWN;
                case 1 -> tempColor = Color.WHEAT;
                case 2 -> tempColor = Color.TEAL;
                case 3 -> tempColor = Color.DARKBLUE;
                case 4 -> tempColor = Color.OLIVE;
                default -> tempColor = Color.GOLD;

            }
        }while (tempColor == color );
        return tempColor;
    }
    private Color getNextColor(){
        if(indiceColoreMattonella == colors.size()-1){
            indiceColoreMattonella = 0;
        }else {
            indiceColoreMattonella++;
        }
        return colors.get(indiceColoreMattonella);
    }
    private void checkVisibility(){
        if (index == 0) {
            prev.setDisable(true);
            next.setDisable(false);
        }else if(index == archivio.size()-1){
            prev.setDisable(false);
            next.setDisable(true);
        }else{
            prev.setDisable(false);
            next.setDisable(false);
        }
    }
    private void setColors() {
        colors.add(Color.BROWN);
        colors.add(Color.WHEAT);
        colors.add(Color.TEAL);
        colors.add(Color.DARKBLUE);
        colors.add(Color.OLIVE);
        colors.add(Color.GOLD);
    }
    private void addFirstElements() {
        Mattonella m1 = new Normale("P1", 50.0f, 50, "ceramica", false );
        Mattonella m2 = new Normale("P2", 80.0f, 20, "laminato", true );
        Mattonella m3 = new Normale("P3", 40.0f, 50, "terracotta", true );
        Mattonella m4 = new Bicolore("B1", 40.0f, 100, "laminato", false, Interno.QUADRATO );
        Mattonella m5 = new Bicolore("B2", 90.0f, 120, "ceramica", true, Interno.CERCHIO );
        Mattonella m6 = new Bicolore("B3", 50.0f, 140, "terracotta", true, Interno.QUADRATO );

        archivio.add(m1);
        archivio.add(m2);
        archivio.add(m3);
        archivio.add(m4);
        archivio.add(m5);
        archivio.add(m6);
    }
    private void setPaneColor(Color color) {
        pane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
