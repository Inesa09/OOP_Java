package com.inesonjka;

import java.util.Scanner;

public class Fibonacci {
//    boolean change=false;
//    public long getNumber(int position) {
//        if (!change) {
//            if(position<= 0)
//                return -1;
//            position--;
//            change = true;
//        }
//        if (position == 1 || position == 0)
//            return 1;
//        return getNumber(position - 1) + getNumber(position - 2);
//    }

    public long getNumber(int position) {
        if(position< 1)
            return -1;
        if (position == 1 || position == 2)
            return 1;
        return getNumber(position - 1) + getNumber(position - 2);
    }

    public static void main(String arg[]) {
        Fibonacci f = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        System.out.println(f.getNumber(scanner.nextInt()));
    }
}
