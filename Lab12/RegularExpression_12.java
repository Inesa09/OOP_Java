import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command, string;
        boolean found;

        while (true) {
            System.out.println("What you want to check?"
                    + "\n name"
                    + "\n surname"
                    + "\n address"
                    + "\n date"
                    + "\n phone");
            command = scanner.nextLine();
            if (command.equals("name") || command.equals("surname") || command.equals("address")) {
                string = scanner.nextLine();
                found = validString(string);
                System.out.println(String.valueOf(found));
            }
            if (command.equals("date")) {
                string = scanner.nextLine();
                found = validBirthDate(string);
                System.out.println(String.valueOf(found));
            }
            if (command.equals("phone")) {
                string = scanner.nextLine();
                found = validPhone(string);
                System.out.println(String.valueOf(found));
            }
        }
    }

    public static boolean validString(String string) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
            return false;
        else
            return true;
    }

    public static boolean validBirthDate(String string) {
        Pattern pattern = Pattern.compile("^\\d\\d[.]\\d\\d[.]\\d\\d\\d\\d$");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
            return true;
        else
            return false;
    }

    public static boolean validPhone(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
            return false;
        else
            return true;
    }
}
