package basic.minandmax;

public class FindMinAndMax {
	public static void main(String[] args) {
		int[] numbers = {0, 10, 7, 5, 6};
		int[] minAndMax = findMinAndMax(numbers);
		System.out.println("최소값: " + minAndMax[0]);
		System.out.println("최대값: " + minAndMax[1]);

		int[] numbers2 = {-5, -2, 5, 0, -1};
		int[] minAndMax2 = findMinAndMax(numbers2);
		System.out.println("최소값: " + minAndMax2[0]);
		System.out.println("최대값: " + minAndMax2[1]);

		int[] numbers3 = {-5, -2, -10, -4, -3};
		int[] minAndMax3 = findMinAndMax(numbers3);
		System.out.println("최소값: " + minAndMax3[0]);
		System.out.println("최대값: " + minAndMax3[1]);

		int[] numbers4 = {-12, -50, 1, 4, 3};
		int[] minAndMax4 = findMinAndMax(numbers4);
		System.out.println("최소값: " + minAndMax4[0]);
		System.out.println("최대값: " + minAndMax4[1]);
	}

	public static int[] findMinAndMax(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		for (int num : arr) {
			if (num < min) {
				min = num;
			}

			if (num > max) {
				max = num;
			}
		}

		return new int[]{min, max};
	}
}
