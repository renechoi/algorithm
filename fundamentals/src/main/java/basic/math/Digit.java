package basic.math;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Digit {

	@Test
	public static void test(){
		Assertions.assertEquals(1, calculate(1));
		Assertions.assertEquals(1, calculate2(1));
		Assertions.assertEquals(1, calculate3(1));
		Assertions.assertEquals(1, calculate4(1));
		Assertions.assertEquals(1, calculate5(1));

		Assertions.assertEquals(1, calculate(9));
		Assertions.assertEquals(1, calculate2(9));
		Assertions.assertEquals(1, calculate3(9));
		Assertions.assertEquals(1, calculate4(9));
		Assertions.assertEquals(1, calculate5(9));

		Assertions.assertEquals(2, calculate(10));
		Assertions.assertEquals(2, calculate2(10));
		Assertions.assertEquals(2, calculate3(10));
		Assertions.assertEquals(2, calculate4(10));
		Assertions.assertEquals(2, calculate5(10));

		Assertions.assertEquals(2, calculate(11));
		Assertions.assertEquals(2, calculate2(11));
		Assertions.assertEquals(2, calculate3(11));
		Assertions.assertEquals(2, calculate4(11));
		Assertions.assertEquals(2, calculate5(11));

		Assertions.assertEquals(2, calculate(99));
		Assertions.assertEquals(2, calculate2(99));
		Assertions.assertEquals(2, calculate3(99));
		Assertions.assertEquals(2, calculate4(99));
		Assertions.assertEquals(2, calculate5(99));

		Assertions.assertEquals(3, calculate(100));
		Assertions.assertEquals(3, calculate2(100));
		Assertions.assertEquals(3, calculate3(100));
		Assertions.assertEquals(3, calculate4(100));
		Assertions.assertEquals(3, calculate5(100));

		Assertions.assertEquals(3, calculate(101));
		Assertions.assertEquals(3, calculate2(101));
		Assertions.assertEquals(3, calculate3(101));
		Assertions.assertEquals(3, calculate4(101));
		Assertions.assertEquals(3, calculate5(101));

		Assertions.assertEquals(4, calculate(1000));
		Assertions.assertEquals(4, calculate2(1000));
		Assertions.assertEquals(4, calculate3(1000));
		Assertions.assertEquals(4, calculate4(1000));
		Assertions.assertEquals(4, calculate5(1000));

		Assertions.assertEquals(4, calculate(1223));
		Assertions.assertEquals(4, calculate2(1223));
		Assertions.assertEquals(4, calculate3(1223));
		Assertions.assertEquals(4, calculate4(1223));
		Assertions.assertEquals(4, calculate5(1223));
	}
	public static void main(String[] args) {
		test();
	}

	/**
	 * 입력된 숫자의 자리수에 비례하는 반복문이 수행되며 입력된 숫자의 자리수를 k라고 할 때, 시간 복잡도는 O(k).
	 *
	 * 이 방식은 반복문을 사용하여 간단하고 직관적이다. 정수를 직접 연산하여 자리수를 계산하므로 추가적인 객체 생성이 필요하지 않다.
	 * 따라서 성능면에서 효율이 좋다.
	 * @param number
	 * @return
	 */
	public static int calculate(int number){
		int count=0;
		while (number>0){
			number /= 10;
			count++;
		}
		return count;
	}

	/**
	 * 순수 배열을 이용해 풀이하는 방식.
	 * 입력된 숫자를 순회하면서 각 자리수를 배열 digits에 기록한다.
	 * 그리고 배열에서 0이 아닌 원소의 개수를 세어 자리수를 구한다.
	 * 입력된 숫자의 자리수에 비례하는 시간 복잡도를 가지므로 시간 복잡도는 O(k)로 동일하다.
	 *
	 * 원리적으로 나머지를 이용한 방식과 동일하다. 그러나 굳이 배열을 사용하는 이유는 활용성 차원에서 보다 유연할 수 있기 때문이다.
	 * 예를 들어, 배열에서 0이 아닌 원소의 위치를 찾거나 각 자리수의 합을 계산하는 등의 작업을 더 쉽게 수행할 수 있다.
	 * 이러한 유연성은 특정한 자리수와 관련된 계산이 필요한 경우에 유용하다.
	 * @param number
	 * @return
	 */
	public static int calculate2(int number) {
		if (number == 0) {
			return 1;
		}

		int[] digits = new int[10];
		int digit =0;
		// 숫자의 각 자리수를 배열에 기록
		while (number > 0) {
			digits[digit++]++;
			number /= 10;
		}

		// 배열에서 0이 아닌 원소의 개수가 자리수를 나타냄
		int count =0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				count++;
			}
		}
		return count;
	}


	/**
	 * 입력된 숫자의 자리수에 따라 log10 값을 계산한 후 1을 더하여 자리수를 구한다.
	 * 음수일 경우에는 절댓값을 취하여 계산한다.
	 * 입력된 숫자의 자리수에 비례하는 시간 복잡도를 가지므로 시간 복잡도는 O(k).
	 *
	 * 추가적인 객체 생성이 필요하지 않다는 면에서 장점이 있다.
	 * 다른 방식과 동일한 성능과 효율을 가지면서
	 * 수학적인 계산을 활용하여 자리수를 판별하므로 보다 간결하고 직관적일 수 있다.
	 * @param number
	 * @return
	 */
	public static int calculate3(int number) {
		if (number == 0) {
			return 1;
		} else {
			return (int) Math.log10(Math.abs(number)) + 1;
			// return (int) (Math.log10(number) + 1); // 절대값을 빼고 구해도 된다.
		}
	}



	/**
	 * 숫자를 문자열로 변환하는 작업(String.valueOf(number))은 입력된 숫자의 자리수에 비례하며
	 * 문자열의 길이를 계산하는 작업(length())은 상수 시간이 소요된다.
	 * 따라서 입력된 숫자의 자리수를 k라고 할 때, 시간 복잡도는 O(k).
	 *
	 * 문자열로 변환하는 작업은 비용이 크고 추가적인 객체 생성을 필요로 한다.
	 * 또한, 숫자를 문자열로 변환하고 길이를 계산하는 과정에서 많은 메모리를 사용할 수 있다.
	 * 따라서 성능과 효율면에서는 나머지를 이용한 수학적인 방식보다 떨어진다.
	 * @param number
	 * @return
	 */
	public static int calculate4(int number){
		return String.valueOf(number).length();
	}

	/**
	 * Stream을 사용하여 입력된 숫자를 10으로 나누는 작업을 반복하며
	 * 입력된 숫자의 자리수에 비례하여 반복하므로
	 * 따라서 입력된 숫자의 자리수를 k라고 할 때, 시간 복잡도는 O(k).
	 *
	 * Stream을 사용하여 코드가 더욱 간결하고 함수형적인 스타일로 작성할 수 있다는 장점이 있다.
	 * @param number
	 * @return
	 */
	public static long calculate5(int number) {
		return Stream.iterate(number, n -> n / 10)
			.takeWhile(n -> n > 0)
			.count();
	}

}


