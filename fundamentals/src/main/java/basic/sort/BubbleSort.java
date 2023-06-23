package basic.sort;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSort {
	public static void main(String[] args) {
		test();
	}

	@Test
	public static void test(){
		int[] arr0 = {10, 20, 30, 40, 50};
		int[] sortedArr0_1 = bubbleSortAsc(arr0);
		Assertions.assertArrayEquals(new int[]{10, 20, 30, 40, 50}, sortedArr0_1);

		int[] arr1 = {50, 20, 30, 10, 40};
		int[] sortedArr1_1 = bubbleSortAsc(arr1);
		Assertions.assertArrayEquals(new int[]{10, 20, 30, 40, 50}, sortedArr1_1);

		int[] arr2 = {4, 7, 2, 10, 180, 99, 50, 30, 15, 0};
		int[] sortedArr2_1 = bubbleSortAsc(arr2);
		int[] sortedArr2_2 = bubbleSortDesc(arr2);
		Assertions.assertArrayEquals(new int[]{0, 2, 4, 7, 10, 15, 30, 50, 99, 180}, sortedArr2_1);
		Assertions.assertArrayEquals(new int[]{180, 99, 50, 30, 15, 10, 7, 4, 2, 0}, sortedArr2_2);

		int[] arr3 = {1};
		int[] sortedArr3_1 = bubbleSortAsc(arr3);
		int[] sortedArr3_2 = bubbleSortDesc(arr3);
		Assertions.assertArrayEquals(new int[]{1}, sortedArr3_1);
		Assertions.assertArrayEquals(new int[]{1}, sortedArr3_2);

		int[] arr4 = {};
		int[] sortedArr4_1 = bubbleSortAsc(arr4);
		int[] sortedArr4_2 = bubbleSortDesc(arr4);
		Assertions.assertArrayEquals(new int[]{}, sortedArr4_1);
		Assertions.assertArrayEquals(new int[]{}, sortedArr4_2);

		int[] arr5 = {60, 20, 70, 10, 80, 30, 50, 40};
		int[] sortedArr5_1 = bubbleSortAsc(arr5);
		int[] sortedArr5_2 = bubbleSortDesc(arr5);
		Assertions.assertArrayEquals(new int[]{10, 20, 30, 40, 50, 60, 70, 80}, sortedArr5_1);
		Assertions.assertArrayEquals(new int[]{80, 70, 60, 50, 40, 30, 20, 10}, sortedArr5_2);
	}

	public static int[] bubbleSortAsc(int[] array){
		 int[] arranged = Arrays.copyOf(array, array.length);
		 boolean exchange;

		 for(int i =0; i< array.length- 1; i++){
			 exchange = false;
			 for(int j =0; j < array.length -1 -i; j++){
				 if (arranged[j] > arranged[j+1]){
					 swap(arranged, j);
					 exchange = true;
				 }
			 }
			 if (!exchange){
				 break;
			 }

		 }
		 return arranged;
	}

	public static int[] bubbleSortDesc(int[] array) {
		int[] arranged = Arrays.copyOf(array, array.length);

		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length -1 - i; j++) {
				if (arranged[j] < arranged[j + 1]) {
					swap(arranged, j);
				}
			}
		}
		return arranged;
	}

	private static void swap(int[] array, int i) {
		int temp = array[i];
		array[i] = array[i+1];
		array[i+1] = temp;
	}

}




