
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] triNumbers = new int[1000];
		int n =0;
		int triCount =0;
		do {
			n++;
			triNumbers[n] = n * (n + 1) / 2;
			triCount++;
		} while (triNumbers[n] < 998);

		boolean[] triNumbersSum = new boolean[1001];
		createSummationMap(triNumbers, triCount, triNumbersSum);

		StringBuilder stringBuilder = new StringBuilder();
		while (N-->0){
			int answer = triNumbersSum[Integer.parseInt(bufferedReader.readLine())] ? 1: 0;
			stringBuilder.append(answer).append("\n");
		}

		System.out.print(stringBuilder);
	}

	private static void createSummationMap(int[] triNumbers, int triCount, boolean[] triNumbersSum) {
		for (int i = 1; i<= triCount; i++){
			for (int j = i; j<= triCount; j++){
				for (int k = j; k<= triCount; k++){
					int sum = triNumbers[i] + triNumbers[j] + triNumbers[k];
					if (sum >=1001){
						continue;
					}
					triNumbersSum[sum] = true;
				}
			}
		}
	}
}

