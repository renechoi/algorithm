import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = bufferedReader.readLine();

		System.out.println(getRequiredBracketCount(inputString));
	}

	public static long getRequiredBracketCount(String inputString) {
		Stack<Character> stack = new Stack<>();
		int 매칭안된괄호 = 0;

		for (char bracket : inputString.toCharArray()) {

			if (stack.isEmpty() || isBracketOpen(bracket)) {
				stack.add(bracket);
				continue;
			}

			if (isBracketMatch(bracket,stack) ) {
				stack.pop();
				continue;
			}
			매칭안된괄호++;

		}

		return (long) stack.size() + 매칭안된괄호;
	}

	private static boolean isBracketOpen(char bracket) {
		return bracket == '(';
	}

	private static boolean isBracketMatch(char bracket, Stack<Character> stack) {
		return (stack.peek() == '(' && bracket == ')');
	}
}