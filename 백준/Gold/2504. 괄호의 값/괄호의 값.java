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

		System.out.println(calculateBracketValue(stringTokenizer.nextToken()));
	}

	private static int calculateBracketValue(String bracketString) {
		Deque<Character> stack = new LinkedList<>();
		Deque<Integer> valueStack = new LinkedList<>();

		for (char ch : bracketString.toCharArray()) {
			if (ch == '(' || ch == '[') {
				stack.push(ch);
				valueStack.push(0); // 임시 값으로 0을 삽입
			} else if (ch == ')') {
				if (isNotMatch(stack, '(')) {
					return 0; // 올바르지 않은 괄호
				}
				stack.pop();
				int value = valueStack.pop();
				int newValue = value == 0 ? 2 : value * 2; // 괄호값 계산
				addToPrevious(valueStack, newValue);
			} else if (ch == ']') {
				if (isNotMatch(stack, '[')) {
					return 0; // 올바르지 않은 괄호
				}
				stack.pop();
				int value = valueStack.pop();
				int newValue = value == 0 ? 3 : value * 3; // 괄호값 계산
				addToPrevious(valueStack, newValue);
			}
		}

		if (!stack.isEmpty())
			return 0; // 남아있는 괄호가 있다면 올바르지 않은 괄호열

		return valueStack.stream().mapToInt(Integer::intValue).sum(); // 최종 값 계산
	}

	private static boolean isNotMatch(Deque<Character> stack, char aChar) {
		return stack.isEmpty() || stack.peek() != aChar;
	}

	private static void addToPrevious(Deque<Integer> valueStack, int newValue) {
		if (!valueStack.isEmpty()) {
			int previousValue = valueStack.pop();
			valueStack.push(previousValue + newValue);
		} else {
			valueStack.push(newValue);
		}
	}
}