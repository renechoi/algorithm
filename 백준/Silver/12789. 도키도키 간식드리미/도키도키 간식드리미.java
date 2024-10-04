import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	// 메인 함수: 제출용
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		Stack<Integer> stack = new Stack<>();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int 순번 = 1;

		while (N-- > 0) {
			int 학생 = Integer.parseInt(stringTokenizer.nextToken());

			while (!stack.isEmpty() && stack.peek() == 순번) {
				stack.pop();
				순번++;
			}

			if (학생 == 순번) {
				순번++;
			} else {
				stack.add(학생);
			}
		}

		while (!stack.isEmpty() && stack.peek() == 순번) {
			stack.pop();
			순번++;
		}

		System.out.println(stack.isEmpty() ? "Nice" : "Sad");
	}

	// JUnit 테스트를 위한 solution 메서드 (테스트 코드에서 사용)
	public static String solution(BufferedReader bufferedReader) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());

		Stack<Integer> stack = new Stack<>();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int 순번 = 1;

		while (N-- > 0) {
			int 학생 = Integer.parseInt(stringTokenizer.nextToken());

			while (!stack.isEmpty() && stack.peek() == 순번) {
				stack.pop();
				순번++;
			}

			if (학생 == 순번) {
				순번++;
			} else {
				stack.add(학생);
			}
		}

		while (!stack.isEmpty() && stack.peek() == 순번) {
			stack.pop();
			순번++;
		}

		return stack.isEmpty() ? "Nice" : "Sad";
	}
}