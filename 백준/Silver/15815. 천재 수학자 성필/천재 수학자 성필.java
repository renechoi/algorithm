import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = bufferedReader.readLine();

		Stack<Integer> 스택 = new Stack<>();

		System.out.println(스택을이용한후위연산(inputString, 스택));
	}

	public static int 스택을이용한후위연산(String inputString, Stack<Integer> 스택) {
		for (char c : inputString.toCharArray()) {
			if (isNumeral(c)) {
				스택.add(숫자로변환하기(c)); 
				continue;
			} 
			
			if (is연산자(c)) {
				int n2 = 스택.pop();
				int n1 = 스택.pop();
				int result = 연산하기(n1, n2, c);
				스택.add(result);
			}
		}
		return 스택.pop(); 
	}

	private static boolean isNumeral(char c) {
		return c >= '0' && c <= '9'; 
	}

	private static int 숫자로변환하기(char c) {
		return c - '0'; 
	}

	private static boolean is연산자(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/'; 
	}

	private static int 연산하기(int n1, int n2, char 연산자) {
		switch (연산자) {
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
			case '/':
				return n1 / n2;
			default:
				throw new IllegalArgumentException("유효하지 않은 연산자: " + 연산자);
		}
	}
}