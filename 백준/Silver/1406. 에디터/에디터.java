import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		String string = stringTokenizer.nextToken();
		List<Character> strings = new LinkedList<>();
		for (char c : string.toCharArray()) {
			strings.add(c);
		}

		stringTokenizer = receiveInput(bufferedReader);
		int commandCounts = parseInt(stringTokenizer.nextToken());

		ListIterator<Character> listIterator = strings.listIterator(strings.size());

		// L -> 커서를 왼쪽으로. 맨 앞이면 무시
		// D -> 커서를 오른쪽으로. 맨 뒤면 무시
		// B -> 커서 왼쪽의 문자를 삭제. 맨 앞이면 무시
		// P x -> 입력 받은 문자를 커서 왼쪽에 추가
		for (int i = 0; i < commandCounts; i++) {
			stringTokenizer = receiveInput(bufferedReader);
			char cmd = stringTokenizer.nextToken().charAt(0);

			switch (cmd) {
				case 'L':
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					break;

				case 'D':
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					break;

				case 'B':
					if (listIterator.hasPrevious()) {
						listIterator.previous();
						listIterator.remove();
					}
					break;

				case 'P':
					char ch = stringTokenizer.nextToken().charAt(0);
					listIterator.add(ch);
					break;
			}
		}

		StringBuilder answer = new StringBuilder();
		for (char c : strings) {
			answer.append(c);
		}
		System.out.println(answer);
	}

}