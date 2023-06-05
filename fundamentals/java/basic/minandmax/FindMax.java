package basic.minandmax;

public class FindMax {
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
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length-1; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
}
