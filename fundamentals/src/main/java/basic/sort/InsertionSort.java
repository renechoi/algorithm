package basic.sort;

public class InsertionSort {
	public static void main(String[] args) {
		insertionSort(new int[]{5, 3, 1});
	}

	public static void insertionSort(int[] arr){
		for (int i =0; i< arr.length; i++){
			for (int j =0; j<i; j++){
				// i => 0 j = x
				// i => 1 j = 0
				// i => 2 j = 0, 1
				// i => 3 j = 0, 1, 2

				if (arr[i] < arr[j]){
					int currentValue = arr[i];
					stepBackward(arr, i, j);
					overWrite(arr, j, currentValue);
					break;
				}
			}
		}
	}

	private static void overWrite(int[] arr, int index, int value) {
		arr[index] = value;
	}

	private static void stepBackward(int[] arr, int end, int currentIndex) {
		for (int i = end; i > currentIndex; i--){
			overWrite(arr, i, arr[i - 1]);
		}
	}
}
