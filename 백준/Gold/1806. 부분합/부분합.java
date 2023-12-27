import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int numberCounts = parseInt(stringTokenizer.nextToken());
		int requiredSummation = parseInt(stringTokenizer.nextToken());

		int[] numbers = new int[numberCounts];
		stringTokenizer = receiveInput(bufferedReader);
		for (int i = 0; i < numberCounts; i++) {
			numbers[i] = parseInt(stringTokenizer.nextToken());
		}

		int start = 0; // 초기 포인터는 둘 다 0으로 시작하고 같은 방향으로 간다.
		int end = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE; // 최소값을 구해야 하므로 가장 큰 값으로 초기화 한다.

		// 1. end 기준으로 summation을 한다.
		// 2. 만약 해당 값이 requiredSummation 보다 같거나 크다면
		//  2-1. 만족시킨 것이므로 길이를 구한다.
		// 	2-2. 구한 길이가 최소값인지를 판단하고 갱신한다.
		//  2-3. 값을 구했으므로 다음 연산을 수행한다 -> 작은 값을 올려서 여전히 requiredSummation을 만족하는지 판단해야 한다.
		// 3. 해당 값이 작다면 숫자가 더 필요하므로 end를 올린다.
		// 4. 종료 조건은 end가 범위를 넘어가는 시점이다.

		while (true) {
			if (sum >= requiredSummation) {
				minLength = Math.min(minLength, end - start);
				sum -= numbers[start++];
			} else if (end == numberCounts) {
				break;
			} else {
				sum += numbers[end++];
			}
		}

		System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
	}

}