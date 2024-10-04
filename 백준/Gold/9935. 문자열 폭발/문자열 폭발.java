import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String 입력문자열 = br.readLine();
		String 폭발문자열 = br.readLine();

		System.out.println(removeBombs(입력문자열, 폭발문자열));
	}

	private static String  removeBombs(String 입력문자열, String 폭발문자열) {
		int bombLength = 폭발문자열.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < 입력문자열.length(); i++) {

			stack.push(입력문자열.charAt(i));

			if (스택의문자열이폭발문자열보다같거나긴경우에만(stack, bombLength)) {
				boolean isBomb = true;

				for (int j = 0; j < bombLength; j++) {
					if (폭발문자열길이만큼앞으로돌아가서j번째(stack, bombLength, j) != 폭발문자열의j번째(폭발문자열, j)) {
						isBomb = false;
						break;
					}
				}

				if (isBomb) {
					for (int j = 0; j < bombLength; j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (Character c : stack) {
			result.append(c);
		}

		if (result.length()==0) {
			return "FRULA";
		} else {
			return result.toString();
		}
	}

	private static char 폭발문자열의j번째(String 폭발문자열, int j) {
		return 폭발문자열.charAt(j);
	}

	private static Character 폭발문자열길이만큼앞으로돌아가서j번째(Stack<Character> stack, int bombLength, int j) {
		return stack.get(stack.size() - bombLength + j);
	}

	private static boolean 스택의문자열이폭발문자열보다같거나긴경우에만(Stack<Character> stack, int bombLength) {
		return stack.size() >= bombLength;
	}
}