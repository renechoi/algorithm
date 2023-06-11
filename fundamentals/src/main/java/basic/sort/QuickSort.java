package basic.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr1 = {5, 2, 8, 6, 1, 9, 3};
		int[] original1 = Arrays.copyOf(arr1, arr1.length);
		quickSort(arr1, 0, arr1.length - 1);
		System.out.println("원본 배열: " + Arrays.toString(original1) + " 정렬된 배열: " + Arrays.toString(arr1));

		int[] arr2 = {30, 45, 20, 15, 40, 25, 35, 10};
		int[] original2 = Arrays.copyOf(arr2, arr2.length);
		quickSort(arr2, 0, arr2.length - 1);
		System.out.println("원본 배열: " + Arrays.toString(original2) + " 정렬된 배열: " + Arrays.toString(arr2));
	}

	// 퀵 정렬을 호출하는 메인 함수
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right); 	// 피벗을 기준으로 분할
			quickSort(arr, left, pivot - 1); // 왼쪽 부분 배열에 대해 퀵 정렬 재귀 호출
			quickSort(arr, pivot + 1, right); // 오른쪽 부분 배열에 대해 퀵 정렬 재귀 호출
		}
	}

	// 퀵 정렬에 핵심이 되는 분할 함수
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];	// 맨 첫 번째 요소를 피벗으로 선택
		int i = left + 1;
		int j = right;

		while (i <= j) {
			if (arr[i] <= pivot) {
				i++;
			} else if (arr[j] > pivot) {
				j--;
			} else {
				swap(arr, i, j);	// 찾은 두 요소를 교환
				i++;
				j--;
			}
		}

		swap(arr, left, j);		// 피벗을 분할 기준으로 위치시킴
		return j;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
