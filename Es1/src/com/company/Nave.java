package com.company;

public class Nave {
    private static Auto[] automobili;
    public static void main(String[] args) {
         automobili = new Auto[10];

    }

    public void caricaAuto(Auto auto){

        for (int i = 0; i < automobili.length; i++) {
            if(automobili[i] == null){
                automobili[i] = auto;
            }
        }
    }
}
