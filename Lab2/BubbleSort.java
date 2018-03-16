package com.inesonjka;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;
        boolean change = false;
        for (int i=0; i < length; i++) {
            for (int j = i; j < length-1; j++) {
                int k = j+1;
                change = false;
                if (array[j] > array[k]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                    change = true;
                }
            }
            if (!change)
                break;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

