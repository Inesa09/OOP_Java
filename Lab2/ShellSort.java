package com.inesonjka;

public class ShellSort {
//    public static int[] array = {30, 2, 10, 4, 6};
    public static void main(String[] args) {
        int[] array = {30, 2, 10, 4, 6};
        int length = array.length;
        int gap = length/2;
        int k = 0;

        do {
            for (int i = 0; i < length - gap; i++) {
                if (array[i] > array[i + gap]) {
                    swap (array, i, i+gap);
//                    array[i + gap] = swap(array[i], array[i] = array[i + gap]);
                    k = i;

                    while ((i - gap) >= 0) {
                        if (array[i - gap] > array[i]) {
                            swap (array, i-gap, i);
//                            array[i]= swap(array[i - gap], array[i - gap] = array[i]);

                        } else
                            break;
                    }

                    if (k != 0) {
                        i = k;
                    }
                }
            }
            gap /= 2;
        } while (gap!=0);


        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

//    public static int swap (int a, int b){
//        return a;
//    }

    public static void swap (int array [], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
