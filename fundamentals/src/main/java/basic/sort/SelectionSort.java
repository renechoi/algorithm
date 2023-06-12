package basic.sort;


import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr1 = {6, 2, 7, 1, 8, 3, 5, 4 };
		int[] sortedArr1 = selectionSort(arr1);
		System.out.println("원본 배열: " + Arrays.toString(arr1) + " 정렬된 배열: " + Arrays.toString(sortedArr1));

		int[] arr2 = {9, 5, 2, 8, 1};
		int[] sortedArr2 = selectionSort(arr2);
		System.out.println("원본 배열: " + Arrays.toString(arr2) + " 정렬된 배열: " + Arrays.toString(sortedArr2));
	}

	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		int[] sortedArr = Arrays.copyOf(arr, n); // 정렬된 배열을 담을 복사본 생성

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			// 미정렬 부분 arr[i..n-1]에서 최솟값 찾기
			minIndex = findMinElementIndex(n, sortedArr, i, minIndex);

			// 미정렬 부분의 첫 번째 원소와 최솟값 교환
			swap(sortedArr, i, minIndex);
		}
		return sortedArr;
	}

	private static int findMinElementIndex(int n, int[] sortedArr, int i, int minIndex) {
		for (int j = i + 1; j < n; j++) {
			if (sortedArr[j] < sortedArr[minIndex]) {
				minIndex = j;
			}
		}
		return minIndex;
	}

	private static void swap(int[] sortedArr, int i, int minIndex) {
		int temp = sortedArr[i];
		sortedArr[i] = sortedArr[minIndex];
		sortedArr[minIndex] = temp;
	}
}
