import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();
        while (testCase-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) {
                stack.pop();
                continue;
            }
            stack.push(number);
        }
        System.out.println(stack.stream().mapToInt(i -> i).sum());
    }
}
