public class Decription {
    public static void main(String[] args) {
        String message = args[0];
        if (args.length != 1 || message.isEmpty() || Character.isDigit(message.charAt(0))) {
            return;
        }

        for (int i = 0; i < message.length()-1; i++) {
            if(message.charAt(i) == message.charAt(i+1) ||
                    (Character.isDigit(message.charAt(i+1)) && Character.isDigit(message.charAt(i)))) {
                return;
            }
        }
        for (int i = 0; i < message.length()-1; i++) {
            if (Character.isDigit(message.charAt(i+1)) ) {
                for (int j = 0; j < Character.digit(message.charAt(i+1), 10); j++) {
                    System.out.print(message.charAt(i));
                }
            }
            else {
                if (Character.isDigit(message.charAt(i)))
                    continue;
                System.out.print(message.charAt(i));
            }
        }
        char last = message.charAt(message.length()-1);
        if (!Character.isDigit(last)) {
            System.out.print(last);
        }

    }
}
