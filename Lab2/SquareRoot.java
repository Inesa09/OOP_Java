package com.inesonjka;

public class SquareRoot {
    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;

        double desk = b*b - 4*a*c;
        double x1, x2;

        if (desk < 0 || (a==0 && b==0) ){
            System.out.println("x1=");
            System.out.println("x2=");
            return;
        }
        else if (a==0) {
            x1 = -1 * c / b;
            x2=x1;
            if (c==0) {
                x1 = -1*x1;
                x2=x1;
            }
        }
        else if (desk == 0) {
            x1 = (-1 * b)/ (2*a);
            x2=x1;
        }
        else {
            desk =  Math.sqrt(desk);
            x1 = (-1 * b + desk)/ (2*a);
            x2 = (-1 * b - desk)/ (2*a);
        }

        System.out.println("x1=" + x1);
        System.out.println("x2=" + x2);
    }
}
