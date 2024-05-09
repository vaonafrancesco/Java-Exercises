package com.company;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Calculator extends Main{
    //ArrayList<String> espressione= new ArrayList<>();
    double num1 = -1, num2 = -1, ris=-1;
    enum Operation {PIU, MENO, PER, DIVISO}
    Operation operation;


    public Calculator() {

    }

    void calculate(ArrayList<String> espressione){
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
        }else {
            text.setText(String.valueOf(ris));
        }
    }
}
