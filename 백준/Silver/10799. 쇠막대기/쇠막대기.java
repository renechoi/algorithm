import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static String pipeWithLaser;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		pipeWithLaser = stringTokenizer.nextToken();

		Stack<Character> stack = new Stack<>();
		Integer answer = 0;
		
		for (int i = 0; i < pipeWithLaser.length(); i++) {
			if (currentCharacter(i) == '(') {
				stack.push(currentCharacter(i));
				continue;
			}
			if (currentCharacter(i) == ')') {
				if (beforeCharacter(i) == '(') {
					stack.pop();
					answer += stack.size();
					continue;
				}

				if (beforeCharacter(i) == ')') {
					stack.pop();
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static char beforeCharacter(int i) {
		return pipeWithLaser.charAt(i - 1);
	}

	private static char currentCharacter(int i) {
		return pipeWithLaser.charAt(i);
	}
}
