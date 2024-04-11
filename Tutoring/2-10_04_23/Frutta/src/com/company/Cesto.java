package com.company;

import java.util.ArrayList;

public class Cesto<T extends Frutto> {
    private ArrayList<T> frutti;
    int dim;

    //constructor
    public Cesto(int dim){
        this.dim = dim;
        frutti = new ArrayList<>(dim);

    }

    public static String conta(Cesto<? extends Frutto> cesto){
        int mele=0, pere=0, arance=0;
        for(Frutto f : cesto.frutti){
            if(f instanceof Mela){
                mele++;
            }
            if(f instanceof Pera){
                pere++;
            }
            if(f instanceof Arancia){
                arance++;
            }
        }
        return "Arance= " + arance + " Mele= " + mele + " Pere= " + pere;

    }

    public boolean add(T frutto){

        if(frutti.size()>dim){
            return false;
        }else{
            frutti.add(frutto);
            return true;
        }
    }
}
