package basic.minandmax.t1;

public class max {

	public static void main(String[] args) {
		int[] numbers = {0, 10, 7, 5, 6};
		System.out.println("최대값: " + findMax(numbers));

		int[] numbers2 = {-5, -2, 5, 0, -1};
		System.out.println("최대값: " + findMax(numbers2));

		int[] numbers3 = {-5, -2, -10, -4, -3};
		System.out.println("최대값: " + findMax(numbers3));

		int[] numbers4 = {-12, -50, 1, 4, 3};
		System.out.println("최대값: " + findMax(numbers4));
	}

	public static int findMax(int[] arr) {
		return findMaxRecursive(arr, 0, arr.length - 1);
	}

	private static int findMaxRecursive(int[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		}

		int mid = (start + end) / 2;
		int leftMax = findMaxRecursive(arr, start, mid);
		int rightMax = findMaxRecursive(arr, mid + 1, end);

		return Math.max(leftMax, rightMax);
	}
}