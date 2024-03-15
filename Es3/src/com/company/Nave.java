package com.company;

public class Nave {

    private Auto[] automobili;
    public Nave(){
        automobili = new Auto[10];

    }

    public void caricaAuto(Auto auto){
        for (int i = 0; i <automobili.length; i++) {
            if(automobili[i]==null){
                automobili[i] = auto;
                break;
            }
        }
    }

    //tostring using Auto.tosString
    public String toString(){
        String s = "";
        for (int i = 0; i <automobili.length; i++) {
            if(automobili[i]!=null){
                s+=automobili[i].toString()+"\n";
            }
        }
        return s;
    }


}
