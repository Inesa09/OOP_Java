package com.inesonjka;

public class Matrix {
    public static void main(String arg[]) {
        int start=0;
        int end=4;
        for (int i=1; i < 25; ) {
            for (int j=0; j < 5; j++) {
                if (j==start || j==end)
                    System.out.print(" * ");
                else {
                    if (i<10)
                        System.out.print(" " + i + " ");
                    else
                        System.out.print(i + " ");
                }
                i++;
            }
            System.out.println();
            start++;
            end--;
        }
    }
}

