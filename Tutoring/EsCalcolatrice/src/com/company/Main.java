package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;


public class Main extends Application {

    enum Operation {PIU, MENO, PER, DIVISO}

    Operation operation;
    Text text = new Text();
    String numeroString = "";
    ArrayList<String> espressione = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        GridPane gp = new GridPane();


        //region button & text declaration

        Button zero = new Button("0");
        Button uno = new Button("1");
        Button due = new Button("2");
        Button tre = new Button("3");
        Button quattro = new Button("4");
        Button cinque = new Button("5");
        Button sei = new Button("6");
        Button sette = new Button("7");
        Button otto = new Button("8");
        Button nove = new Button("9");
        Button AC = new Button("AC");
        Button piu = new Button("+");
        Button meno = new Button("-");
        Button diviso = new Button("/");
        Button per = new Button("x");
        Button del = new Button("del");
        Button uguale = new Button("=");
        text.setText("");
        text.setStyle("-fx-font: 24 arial;");



        //endregion

        //region graphics of Claculator

        //set the number of columns
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            gp.getColumnConstraints().add(column);
            //column.setHgrow(Priority.ALWAYS);
            column.setPercentWidth(50);
        }

        //set the number of rows
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(100);
            gp.getRowConstraints().add(row);
            //row.setVgrow(Priority.ALWAYS);
            row.setPercentHeight(50);
        }

        //pos of bottons
        GridPane.setConstraints(uno, 0, 1);
        GridPane.setConstraints(due, 1, 1);
        GridPane.setConstraints(tre, 2, 1);
        GridPane.setConstraints(diviso, 3, 1);
        GridPane.setConstraints(quattro, 0, 2);
        GridPane.setConstraints(cinque, 1, 2);
        GridPane.setConstraints(sei, 2, 2);
        GridPane.setConstraints(per, 3, 2);
        GridPane.setConstraints(sette, 0, 3);
        GridPane.setConstraints(otto, 1, 3);
        GridPane.setConstraints(nove, 2, 3);
        GridPane.setConstraints(meno, 3, 3);
        GridPane.setConstraints(AC, 0, 4);
        GridPane.setConstraints(zero, 1, 4);
        GridPane.setConstraints(uguale, 2, 4);
        GridPane.setConstraints(piu, 3, 4);
        GridPane.setConstraints(del, 3, 0);
        GridPane.setConstraints(text, 0, 0);

        //set the size
        setButtomnSize(zero, uno, due, tre, quattro, cinque);
        setButtomnSize(sei, sette, otto, nove, del, uguale);
        AC.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        piu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        meno.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        per.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        diviso.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        text.resize(Double.MAX_VALUE, Double.MAX_VALUE);

        //add all the elements to the grid
        gp.getChildren().addAll(zero, uno, due, tre, quattro, cinque, sei, sette, otto, nove, AC, piu, meno, diviso, per, del, text, uguale);

        //endregion


        //region Handling buttons actions

        //cifre
        zero.setOnAction(actionEvent -> {
            numeroString = numeroString + "0";
            text.setText(numeroString);
        });
        uno.setOnAction(actionEvent -> {
            numeroString = numeroString + "1";
            text.setText(numeroString);
        });
        due.setOnAction(actionEvent -> {
            numeroString = numeroString + "2";
            text.setText(numeroString);
        });
        tre.setOnAction(actionEvent -> {
            numeroString = numeroString + "3";
            text.setText(numeroString);
        });
        quattro.setOnAction(actionEvent -> {
            numeroString = numeroString + "4";
            text.setText(numeroString);
        });
        cinque.setOnAction(actionEvent -> {
            numeroString = numeroString + "5";
            text.setText(numeroString);
        });
        sei.setOnAction(actionEvent -> {
            numeroString = numeroString + "6";
            text.setText(numeroString);
        });
        sette.setOnAction(actionEvent -> {
            numeroString = numeroString + "7";
            text.setText(numeroString);
        });
        otto.setOnAction(actionEvent -> {
            numeroString = numeroString + "8";
            text.setText(numeroString);
        });
        nove.setOnAction(actionEvent -> {
            numeroString = numeroString + "9";
            text.setText(numeroString);
        });
        //operazioni
        piu.setOnAction(actionEvent -> {
            text.setText("");
            espressione.add(numeroString);
            espressione.add("+");
            numeroString = "";
        });
        meno.setOnAction(actionEvent -> {
            text.setText("");
            espressione.add(numeroString);
            espressione.add("-");
            numeroString = "";
        });
        per.setOnAction(actionEvent -> {
            text.setText("");
            espressione.add(numeroString);
            espressione.add("*");
            numeroString = "";
        });
        diviso.setOnAction(actionEvent -> {
            text.setText("");
            espressione.add(numeroString);
            espressione.add("/");
            numeroString = "";
        });
        //altri tasti
        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(numeroString == ""){
                    System.out.println("Entrato");
                    return;
                }else{
                    numeroString = numeroString.substring(0, numeroString.length() - 1);
                    text.setText(numeroString);
                }
            }
        });
        AC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numeroString = "";
                text.setText(numeroString);
                espressione.clear();

            }
        });
        uguale.setOnAction(actionEvent -> {


            espressione.add(numeroString);

            double num1 = -1, num2 = -1, ris=-1;
            for (String s : espressione){
                switch (s){
                    case "+":
                        operation = Operation.PIU;
                        break;
                    case "-":
                        operation = Operation.MENO;
                        break;
                    case "*":
                        operation = Operation.PER;
                        break;
                    case "/":
                        operation = Operation.DIVISO;
                        break;
                    default:
                        if (num1<0 && ris<0){
                            try {
                                num1 = parseDouble(s);
                            }catch (Exception e){
                                break;
                            }
                            break;
                        }else if (ris >= 0) {
                            num1 = parseDouble(s);
                            switch (operation){
                                case PIU -> ris = ris + num1;
                                case MENO -> ris = ris - num1;
                                case PER -> ris = ris * num1;
                                case DIVISO -> ris = ris / num1;
                                default -> text.setText("Error");
                            }
                            num1 = -1;
                            break;
                        }else if (num2<0 && ris < 0) {
                            try {
                                num2 = parseDouble(s);
                                switch (operation){
                                    case PIU -> ris = num1 + num2;
                                    case MENO -> ris = num1 - num2;
                                    case PER -> ris = num1 * num2;
                                    case DIVISO -> ris = num1 / num2;
                                    default -> text.setText("Error");
                                }
                                num1 = num2 = -1;
                                break;
                            }catch (Exception e){
                                text.setText("Error");
                                break;
                            }
                        }

                }
            }
            if(ris < 0){
                text.setText("Errore");
            }else{
                text.setText(String.valueOf(ris));
            }
            numeroString = "";
            espressione.clear();
        });

        //endregion


        primarystage.setTitle("Calcolatrice");
        primarystage.setScene(new Scene(gp, 400, 375));
        primarystage.show();
    }

    private void setButtomnSize(Button zero, Button uno, Button due, Button tre, Button quattro, Button cinque) {
        zero.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        uno.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        due.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tre.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        quattro.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        cinque.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

}
