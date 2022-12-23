import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Stack<Character> parenthesis;
    private static boolean parenthesisBalanced;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String sentence = bufferedReader.readLine();//.replace(" ", "");
            if (".".equals(sentence)) {
                break;
            }

            parenthesis = new Stack<>();
            parenthesisBalanced = true;

            for (int i = 0; i < sentence.length(); i++) {
                handleParenthesis(sentence, i);
                if (!parenthesisBalanced){
                    break;
                }
            }

            testBalance();
        }
    }

    private static void testBalance() {
        if (!parenthesisBalanced){
            System.out.println("no");
            return;
        }

        if (parenthesis.empty()) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }

    private static void handleParenthesis(String sentence, int index) {
        char character = sentence.charAt(index);

        if (character == '(') {
            parenthesis.push(character);
            return;
        }

        if (character == '[') {
            parenthesis.push(character);
            return;
        }

        if (character == ')' || character == ']') {
            checkIsBalanced(character);
        }
    }

    private static void checkIsBalanced(char character){
        if (parenthesis.isEmpty()){
            parenthesisBalanced = false;
            return;
        }
        if (character==']'){
            if (parenthesis.peek() == '['){
                parenthesisBalanced = true;
                parenthesis.pop();
                return;
            }
            parenthesisBalanced = false;
        }

        if (character==')'){
            if(parenthesis.peek()=='('){
                parenthesisBalanced = true;
                parenthesis.pop();
                return;
            }
            parenthesisBalanced = false;
        }
    }
}
