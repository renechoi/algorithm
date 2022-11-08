import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] inputNumbers;
	public static int[] sortedArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		inputNumbers = new int[N];
		sortedArray = new int[N];

		for (int i = 0; i < N; i++) {
			inputNumbers[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(0, N - 1);

		for (int i = 0; i < N; i++) {
			bw.write(inputNumbers[i] + "\n");
		}

		bw.flush();
		bw.close();
	}

	private static void mergeSort(int left, int right) {
		if (right - left < 1)
			return;
		int median = left + (right - left) / 2;

		mergeSort(left, median);
		mergeSort(median + 1, right);

		if (right + 1 - left >= 0) {		// 복사하여 새로운 배열에 넣기 
			System.arraycopy(inputNumbers, left, sortedArray, left, right + 1 - left);
		}

		merge(right, median, left);
	}

	private static void merge(int right, int median, int left) {

		int newLeft = left;
		int newRight = median + 1;

		while (newLeft <= median && newRight <= right) {

			if (sortedArray[newLeft] > sortedArray[newRight]) {
				inputNumbers[left] = sortedArray[newRight];
				left++;
				newRight++;
			} else {
				inputNumbers[left] = sortedArray[newLeft];
				left++;
				newLeft++;
			}
		}

		while (newLeft <= median) {
			inputNumbers[left] = sortedArray[newLeft];
			left++;
			newLeft++;
		}

		while (newRight <= right) {
			inputNumbers[left] = sortedArray[newRight];
			left++;
			newRight++;
		}
	}
}
