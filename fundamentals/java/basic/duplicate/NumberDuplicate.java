package basic.duplicate;

import java.util.Arrays;

public class NumberDuplicate {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int requestedNumber1 = 3;
		boolean result1 = isNumberDuplicate(requestedNumber1, arr1);
		System.out.println("Result 1: " + result1);

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
}

