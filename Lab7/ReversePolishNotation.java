import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ReversePolishNotation {
    public static double parse(String rpnString) {
        Deque<Double> stack = new LinkedList<Double>();
        LinkedList<String> list = new LinkedList<String>();

        int counter = 0;
        for (int i = 0; i < rpnString.length(); i++) {
            if (rpnString.indexOf(' ', counter) == i) {
                list.add(rpnString.substring(counter, i));
                counter = i + 1;
            }
        }
        if (counter == 0)
            throw new RPNParserException();
        list.add(Character.toString(rpnString.charAt(rpnString.length() - 1)));
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String got = list.get(i);
//            System.out.println(got);
            if (got.matches("[*-/+]")) {
                if (stack.size()<2) {
                    throw new RPNParserException();
                }
                if (got.equals("+"))
                    stack.push(stack.pop() + stack.pop());
                else if (got.equals("-")) {
                    Double a = stack.pop();
                    Double b = stack.pop();
                    stack.push(b - a);
                }
                else if (got.equals("*"))
                    stack.push(stack.pop() * stack.pop());
                else if (got.equals("/")) {
                    Double a = stack.pop();
                    Double b = stack.pop();
                    if (a == 0)
                        throw new ArithmeticException();
                    stack.push(b / a);
                }
            } else if (got.matches("[-0-9].*")) {
                    stack.push(Double.parseDouble(got));
            } else
                throw new RPNParserException();
        }
        if (stack.size() == 1)
            return stack.pop();
        else
            throw new RPNParserException();
    }

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String rpnString = scan.nextLine();
            double res = parse(rpnString);
            System.out.println(res);
        } catch (RPNParserException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}

class RPNParserException extends RuntimeException {
//    RPNParserException (String message) {
//        super(message);
////        System.out.println("Error in " + message);
//    }
}
