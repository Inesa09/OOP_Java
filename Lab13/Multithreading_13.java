import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Multithreading_13 {
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++)
            collection.add(i);

        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();

        (new TimeCheckerThread(time)).start();
        (new Minimum(collection)).start();
        (new Maximum(collection)).start();
        (new Sum(collection)).start();
    }
}

class Minimum extends Thread {
    ArrayList<Integer> collection = new ArrayList<>();

    Minimum(ArrayList<Integer> collection) {
        this.collection = collection;
    }

    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Integer[] arr = collection.toArray(new Integer[collection.size()]);
            Arrays.sort(arr);
            Thread.sleep(1_000);
            long estimatedTime = System.currentTimeMillis() - startTime;

            System.out.println("Minimum: " + arr[0] + "\nTime: " + estimatedTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Maximum extends Thread {
    ArrayList<Integer> collection;

    Maximum(ArrayList<Integer> collection) {
        this.collection = collection;
    }

    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Integer[] arr = collection.toArray(new Integer[collection.size()]);
            Arrays.sort(arr);
            Thread.sleep(1_000);
            long estimatedTime = System.currentTimeMillis() - startTime;

            System.out.println("Maximum: " + arr[collection.size() - 1] + "\nTime: " + estimatedTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sum extends Thread {
    ArrayList<Integer> collection;

    Sum(ArrayList<Integer> collection) {
        this.collection = collection;
    }

    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            long sum = 0;
            for (int i = 0; i < collection.size(); i++) {
                sum += collection.get(i);
            }

            Thread.sleep(1_000);
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sum: " + sum + "\nTime: " + estimatedTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimeCheckerThread extends Thread {
    long time;

    TimeCheckerThread(long time) {
        this.time = time;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() < startTime + time) {

        }
        System.exit(0);
    }
}
