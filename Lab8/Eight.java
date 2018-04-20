import java.util.ArrayList;
import java.util.Scanner;

public class Eight {
    private static ArrayList<String> groupA = new ArrayList<String>();
    private static ArrayList<String> groupB = new ArrayList<String>();

    public static void main(String[] args) {
        if (args[0].equals("-h") || args[0].equals("-help")) {
            System.out.println("Lab is made by Inesa Hermaniuk CS-110!");
            return;
        }
        String command = command();
        if (command.equals("a"))
            display(args);
        else if (command.equals("b"))
            process(args);
        else if (command.equals("c"))
            result();
        else if (command.equals("d")) {
            System.out.println("End of program!");
            return;
        } else
            System.out.println("Invalid command!");

        main(args);
    }

    private static String command () {
        System.out.println("Choose the command: " +
                "a. display data; " +
                "b. process data; " +
                "c. display result; " +
                "d. end program.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void display (String args []) {
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++)
                System.out.println(args[i]);
        } else
            System.out.println("Invalid data!");
    }

    private static void process (String args []) {
        try {
            int size = Integer.parseInt(args[0]);
            StringBuffer common;
            int length;
            for (int i = 1; i < args.length; i++) {
                common = new StringBuffer(args[i]);
                length = common.length();
                if (length < size)
                    groupA.add(common + " - " + String.valueOf(length));
                else
                    groupB.add(common + " - " + String.valueOf(length));
            }
            System.out.println("Data processed!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter the size firstly!");
        }
    }

    private static void result () {
        System.out.println("Group A: ");
        if (groupA.size() != 0) {
            for (int i = 0; i < groupA.size(); i++)
                System.out.println(groupA.get(i));
        } else
            System.out.println("nothing");
        System.out.println("Group B: ");
        if (groupB.size() != 0) {
            for (int i = 0; i < groupB.size(); i++)
                System.out.println(groupB.get(i));
        } else
            System.out.println("nothing");
    }
}
