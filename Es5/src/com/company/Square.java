package com.company;

public class Square extends Shape{
    private static int total = 0;
    private final int index;
    private final float raggio;
    public Square(float raggio){
        this.raggio = raggio;
        index = total;
        total++;
    }

    @Override
    public float getArea() {
        return (float)(3.14*(raggio*raggio));
    }


    @Override
    public String toString() {
        return "Square " + index + "/" + total + " of " + getArea() +" cm2" ;
    }
}
