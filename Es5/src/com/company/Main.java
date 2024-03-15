package com.company;
import java.util.Random;

public class Main {

    private static final int N = 10;
    static Random random = new Random();

    public static void main(String[] args) {

        Shape[] array = new Shape[N];

        // fill the array with random shapes
        for (int i = 0; i < array.length; i++) {

            // if randomBool is true, create a square, otherwise create a circle
            if(randomBool()){
                array[i] = new Square(randomFloat());
            }else{
                array[i] = new Circle(randomFloat());
            }
        }

        // print the array
        printShapes(array);
    }

    /**
     * Return a random boolean
     * @return
     */
    public static boolean randomBool(){
        // return a random
        return random.nextBoolean();
    }

    /**
     * Return a random float
     * @return
     */
    public static float randomFloat(){
        return random.nextFloat();
    }

    /**
     * Print the array of shapes
     * @param arr
     */
    public static void printShapes(Shape[] arr){
        for (Shape shape : arr) {
            System.out.println(shape);
        }
    }
}
