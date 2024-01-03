import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int T = parseInt(stringTokenizer.nextToken()); // testCases


		while (T-- > 0) {
			stringTokenizer = receiveInput(bufferedReader);
			String input = stringTokenizer.nextToken();
			System.out.println(findPassword(input));
		}
	}

	private static String findPassword(String input) {
		Deque<Character> leftStack = new LinkedList<>();
		Deque<Character> rightStack = new LinkedList<>();

		for (char ch : input.toCharArray()) {
			switch (ch) {
				case '<':
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
					break;
				case '>':
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
					break;
				case '-':
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
					break;
				default:
					leftStack.push(ch);
					break;
			}
		}

		StringBuilder password = new StringBuilder();
		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		while (!rightStack.isEmpty()) {
			password.append(rightStack.pop());
		}

		return password.toString();
	}
}
