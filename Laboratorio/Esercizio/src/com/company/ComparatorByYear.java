package com.company;

import java.util.Comparator;

public class ComparatorByYear implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.annoNascita-o2.annoNascita;
    }
}
