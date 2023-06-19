package basic.math;

import java.util.stream.IntStream;

public class Sum {
	public static void main(String[] args) {
		System.out.println(sum3(3, 7));
		System.out.println(sum2(3, 7));
		System.out.println(sum(3, 7));

		System.out.println(sum3(4, 7));
		System.out.println(sum2(4, 7));
		System.out.println(sum(4, 7));

		System.out.println(sum3(10, 50));
		System.out.println(sum2(10, 50));
		System.out.println(sum(10, 50));

	}

	private static int sum(int start, int end) {
		return IntStream.rangeClosed(start, end).sum();
	}

	private static int sum2(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}

	private static int sum3(int start, int end) {
		int partSum = start + end;
		int length = end - start + 1;
		return partSum * length / 2;
	}
}
