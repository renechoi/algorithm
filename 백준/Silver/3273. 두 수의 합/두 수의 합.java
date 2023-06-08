
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] numbers = new int[N];
		String numberList = bufferedReader.readLine();
		StringTokenizer stringTokenizer = new StringTokenizer(numberList);
		for (int i = 0; i < N; i++) { // O(n)
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int numberToSum = Integer.parseInt(bufferedReader.readLine());

		Arrays.sort(numbers); // O(nlogn)

		int count = 0;
		// for (int i=0;i<numbers.length/2;i++){ // O(n)
		// 	if (numbers[i]+numbers[numbers.length-(i+1)]==numberToSum){
		// 		count++;
		// 	}
		// }


		int start = 0;
		int end = numbers.length-1;
		while (start < end) {   // O(n)
			if (numbers[start] + numbers[end] == numberToSum) {
				start++;
				end--;
				count++;
				continue;
			}

			if (numbers[start] + numbers[end] > numberToSum) {
				end--;
				continue;
			}
			start++;
		}

		System.out.println(count);
	}
}

