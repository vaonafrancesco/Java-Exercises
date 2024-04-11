package com.company;

public class Main{

    public static void main(String[] args) {

        Mela mela = new Mela();

        Cesto<Mela> cestoMela = new Cesto<>(10);

        //crea un cesto misto con 3 mele, 2 pere e 1 arancia
        Cesto<Frutto> cestoMisto = new Cesto<>(10);
        cestoMisto.add(new Mela());
        cestoMisto.add(new Mela());
        cestoMisto.add(new Mela());
        cestoMisto.add(new Pera());
        cestoMisto.add(new Pera());
        cestoMisto.add(new Arancia());


        if (cestoMela.add(mela))
            System.out.println("Mela aggiunta al cesto");
        else
            System.out.println("Cesto pieno");


        //System.out.println(Cesto.conta(cestoMela));
        System.out.println(Cesto.conta(cestoMisto));
    }


}
