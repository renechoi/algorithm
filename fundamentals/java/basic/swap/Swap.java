package basic.swap;

import java.util.Arrays;

public class Swap {
	public static void main(String[] args) {
		swapExample(new Integer[]{1, 2});
		swapExample(new String[]{"a", "b"});
	}

	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static <T> void swapExample(T[] array) {
		swap(array, 0, 1);
		System.out.printf("after: %s%n", Arrays.toString(array));
	}
}
