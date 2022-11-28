import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());
		String number = bufferedReader.readLine();

		Stack<Character> stack = new Stack<>();
		int count =K;
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && count > 0 && stack.peek() < number.charAt(i)) {
				stack.pop();
				count--;
			}
			stack.add(number.charAt(i));
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i=0; i<N-K; i++){
			stringBuilder.append(stack.get(i));
		}
		
//		for (char num : stack) {
//			stringBuilder.append(num);
//		}

		System.out.println(stringBuilder);
	}
}
