import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] sortedArray;
	private static int count = 0;
	private static int answer = -1;
	private static int savingPointK;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int arraySize = Integer.parseInt(stringTokenizer.nextToken());
		savingPointK = Integer.parseInt(stringTokenizer.nextToken());

		int[] array = new int[arraySize];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < arraySize; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		sortedArray = new int[arraySize];
		merge_sort(array, 0, array.length - 1);

		System.out.println(answer);
	}

	private static void merge_sort(int[] array, int left, int right) {
		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;

		merge_sort(array, left, mid);
		merge_sort(array, mid + 1, right);

		merge(array, left, mid, right);
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int leftPointer = left;
		int rightPointer = mid + 1;
		int newArrayIdx = left;

		while (leftPointer <= mid && rightPointer <= right) {
			if (array[leftPointer] <= array[rightPointer]) {
				sortedArray[newArrayIdx] = array[leftPointer];
				leftPointer++;
				newArrayIdx++;
				continue;
			}

			if (array[rightPointer] <= array[leftPointer]) {
				sortedArray[newArrayIdx] = array[rightPointer];
				rightPointer++;
				newArrayIdx++;
			}
		}

		while (leftPointer <= mid) {
			sortedArray[newArrayIdx++] = array[leftPointer++];
		}

		while (rightPointer <= right) {
			sortedArray[newArrayIdx++] = array[rightPointer++];
		}

		for (int i = left; i <= right; i++) {
			count++;
			if (count == savingPointK) {
				answer = sortedArray[i];
			}
			array[i] = sortedArray[i];
		}
	}
}
