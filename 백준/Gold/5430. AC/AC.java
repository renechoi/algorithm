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
			String command = stringTokenizer.nextToken();
			char[] commands = command.toCharArray();

			stringTokenizer = receiveInput(bufferedReader);
			int counts = parseInt(stringTokenizer.nextToken());

			stringTokenizer = receiveInput(bufferedReader);
			Deque<Integer> que = parseStringToQueue(stringTokenizer.nextToken());
			try {
				operate(commands, que);
			} catch (Exception e) {
				System.out.println("error");
			}
		}

	}

	private static void operate(char[] commands, Deque<Integer> que) {
		boolean isReversed = false;
		for (char c : commands) {

			if (c == 'R') {
				isReversed = !isReversed;
			}

			if (c == 'D') {
				if (que.isEmpty()) {
					throw new IllegalStateException();
				}
				if (isReversed) {
					que.removeLast();
				} else {
					que.removeFirst();
				}
			}
		}

		printWithOrder(que, isReversed);
	}

	private static void printWithOrder(Deque<Integer> que, boolean isReversed) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		while (!que.isEmpty()) {
			stringBuilder.append(isReversed ? que.pollLast() : que.pollFirst());
			if (!que.isEmpty()) {
				stringBuilder.append(",");
			}
		}
		stringBuilder.append("]");
		System.out.println(stringBuilder);
	}

	private static Deque<Integer> parseStringToQueue(String input) {
		Deque<Integer> que = new LinkedList<>();
		input = input.substring(1, input.length() - 1);
		String[] numbers = input.split(",");

		for (String number : numbers) {
			if (!number.isEmpty()) {
				que.add(Integer.parseInt(number.trim()));
			}
		}
		return que;
	}
}
