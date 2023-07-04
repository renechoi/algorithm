
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int[] numbers = new int[N];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		while (N-- > 0) {
			numbers[N] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(numbers);
		int smallest = Integer.MAX_VALUE;
		int a = numbers[0];
		int b = numbers[1];
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			int find = binarySearch(i, numbers);
			if (Math.abs(number + find) < smallest){
				smallest = Math.abs(number + find);
				a = Math.min(number, find);
				b = Math.max(number, find);
			}
		}
		System.out.println(a + " " + b);
	}

	private static int binarySearch(int index, int[] numbers) {
		int current = numbers[index];
		int find = numbers[0];
		int sumAbsSmallest = Integer.MAX_VALUE;
		int left = 1 + index; // 자기 자신을 제외하고 시작한다.
		int right = numbers.length -1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) /2;

			int sum = current + numbers[mid];
			int sumAbs = Math.abs(sum);

			if (sumAbs< sumAbsSmallest){
				sumAbsSmallest = sumAbs;
				find = numbers[mid];
			}

			if (sum==0){
				return numbers[mid];
			}
			if (sum <0 ){
				left = mid+1;
			} else{
				right= mid-1;
			}
		}
		return find;
	}


}

