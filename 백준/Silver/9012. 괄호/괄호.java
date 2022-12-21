import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < testCase; i++) {
            String parenthesisString = bufferedReader.readLine();
            printAnswer(isPSV(parenthesisString));
        }
    }

    private static boolean isPSV(String parenthesisString) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parenthesisString.length(); i++) {
            char parenthesis = parenthesisString.charAt(i);
            if (parenthesis == '(') {
                stack.push(parenthesis);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }

        return stack.size() == 0;
    }

    private static void printAnswer(boolean PSV) {
        if (PSV) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}