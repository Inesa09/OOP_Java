package com.inesonjka;

public class BinarySearch {
    public static void main(String[] args) {

        int data[] = { 3, 6, 7, 10, 34, 56, 60};
        int numberToFind = 3;
        int start = 0;
        int end = data.length-1;

        while (start != end) {
            int k = (end+start) / 2;
            if (k == start && k!=0)
                k++;
            if (data[k]==numberToFind) {
                System.out.println(k);
                return;
            }
            else if (data[k] > numberToFind)
                end = k;
            else
                start = k;

        }
        System.out.println(-1);
    }
}
