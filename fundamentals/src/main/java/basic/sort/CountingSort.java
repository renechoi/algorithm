package basic.sort;

import java.util.Arrays;
public class CountingSort {
	public static void main(String[] args) {
		int[] arr1 = {4, 2, 1, 7, 3};
		int[] sortedArr1 = countingSort(arr1, 8, 1); // 입력값 범위: 1부터 8
		System.out.println("원본 배열: " + Arrays.toString(arr1) + " 정렬된 배열: " + Arrays.toString(sortedArr1));

		int[] arr2 = {9, 5, 1, 3, 7};
		int[] sortedArr2 = countingSort(arr2, 10, 1); // 입력값 범위: 1부터 10
		System.out.println("원본 배열: " + Arrays.toString(arr2) + " 정렬된 배열: " + Arrays.toString(sortedArr2));

		int[] arr3 = {8, 4, 2, 6, 10};
		int[] sortedArr3 = countingSort(arr3, 10, 2); // 입력값 범위: 2부터 10
		System.out.println("원본 배열: " + Arrays.toString(arr3) + " 정렬된 배열: " + Arrays.toString(sortedArr3));

		int[] arr4 = {7, 5, 9, 8, 4, 5, 7, 5};
		int[] sortedArr4 = countingSort(arr4, 9, 4); // 입력값 범위: 4부터 9
		System.out.println("원본 배열: " + Arrays.toString(arr4) + " 정렬된 배열: " + Arrays.toString(sortedArr4));
	}

	/**
	 * Counting Sort 알고리즘을 사용하여 배열 A를 정렬하는 메서드입니다.
	 *
	 * @param A   정렬할 배열
	 * @param max 배열 A의 최댓값 (입력값의 범위)
	 * @param min 배열 A의 최솟값 (입력값의 범위)
	 * @return 정렬된 배열 B
	 */
	public static int[] countingSort(int[] A, int max, int min) {
		int[] COUNT = new int[max - min + 1]; // COUNT 배열의 크기는 최댓값과 최솟값의 차이에 1을 더한 값

		for (int j = 0; j < A.length; j++) {
			COUNT[A[j] - min]++; // COUNT 배열의 인덱스는 A[j]의 값에서 최솟값을 뺀 값으로 해당 값의 개수를 카운트
		}

		for (int j = 1; j < COUNT.length; j++) {
			COUNT[j] = COUNT[j] + COUNT[j - 1]; // COUNT 배열을 누적 개수로 업데이트
		}

		int[] B = new int[A.length]; // 정렬된 결과를 저장할 배열 B
		for (int i = A.length - 1; i >= 0; i--) {
			B[COUNT[A[i] - min] - 1] = A[i]; // COUNT 배열을 참조하여 배열 A의 요소를 정렬된 위치에 배치
			COUNT[A[i] - min]--; // COUNT 배열의 해당 값의 개수를 감소
		}

		return B; // 정렬된 배열 B 반환
	}
}




