package basic.minandmax;

public class FindMin {
	public static void main(String[] args) {
		int[] numbers = {5, 8, 2, 9, 1};
		System.out.println("최소값: " + findMin(numbers));
	}

	public static int findMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}
