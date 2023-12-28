import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
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
		int N = parseInt(stringTokenizer.nextToken()); // N -> 버퍼 사이즈

		Queue<Integer> buffer = new LinkedList<>();

		while(true){
			stringTokenizer = receiveInput(bufferedReader);
			int info = parseInt(stringTokenizer.nextToken());

			if (info == -1){
				break;
			}

			if (info == 0){
				buffer.poll();
				continue;
			}

			if(buffer.size() < N){
				buffer.offer(info);
			}
		}
		StringBuilder stringBuilder  = new StringBuilder();
		buffer.forEach(item -> stringBuilder.append(item).append(" "));
		System.out.println(stringBuilder.toString().equals("") ? "empty" : stringBuilder);
	}
}