public class Encription {
    public static void main(String[] args) {
        if (args == null || args.length != 1 || args[0].equals(" ")) {
            System.out.println("Error");
            return;
        }

        String message = args[0];
        int count = 1;
        for (int i = 0; i < message.length(); i++) {
            if (i == message.length() - 1 || message.charAt(i) != message.charAt(i + 1)) {
                while (count > 9) {
                    System.out.print(message.charAt(i));
                    System.out.print(9);
                    count -= 9;
                }
                if (count > 1) {
                    System.out.print(message.charAt(i));
                    System.out.print(count);
                    count = 1;
                } else
                    System.out.print(message.charAt(i));
                continue;
            }
            count++;
        }
    }
}