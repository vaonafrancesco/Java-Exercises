package com.company;

public class Circle extends Shape{
    private static int total;
    private final int index;

    private final float raggio;
    public Circle(float raggio){
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
        return "Circle " + index + "/" + total + " of " + getArea() +" cm2" ;
    }

}
