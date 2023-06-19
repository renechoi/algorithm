package basic.duplicate;

import java.util.Arrays;

public class NumberDuplicate {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int requestedNumber1 = 3;
		boolean result1 = isNumberDuplicate(requestedNumber1, arr1);
		boolean result1_b = isDuplicateExistInArray(arr1);
		System.out.println("Result 1: " + result1);
		System.out.println("Result 1: " + result1_b);

		int[] arr2 = {5, 5, 5, 5, 5};
		int requestedNumber2 = 5;
		boolean result2 = isNumberDuplicate(requestedNumber2, arr2);
		System.out.println("Result 2: " + result2);

		int[] arr3 = {1, 2, 3, 4, 5};
		int requestedNumber3 = 6;
		boolean result3 = isNumberDuplicate(requestedNumber3, arr3);
		System.out.println("Result 3: " + result3);

		int[] arr4 = {1, 1, 2, 2, 3};
		int requestedNumber4 = 1;
		boolean result4 = isNumberDuplicate(requestedNumber4, arr4);
		System.out.println("Result 4: " + result4);
	}

	private static boolean isNumberDuplicate(int requestedNumber, int[] arr) {
		return Arrays.stream(arr).filter(numberInArray -> numberInArray == requestedNumber)
			.count() > 1;
	}

	/**
	 * 시간 복잡도 O(n^2)
	 * @param arr
	 * @return
	 */
	private static boolean isDuplicateExistInArray(int[] arr){
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 시간 복잡도 O(nlogn)
	 * @param arr
	 * @return
	 */
	private static boolean isDuplicateExistInArray2(int[] arr) {
		Arrays.sort(arr);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 시간 복잡도 O(n)
	 * @param arr
	 * @return
	 */
	private static boolean isDuplicateExistInArray3(int[] arr) {
		return Arrays.stream(arr)
			.distinct()
			.count() != arr.length;
	}


}

