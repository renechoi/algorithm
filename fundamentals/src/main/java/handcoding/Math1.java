package handcoding;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Math1 {

	public static void main(String[] args) {
		addTimeTest();

	}

	// 3의 배수의 합을 구하라
	public static void problem1() {
		int start = 1;
		int end = 10;

		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

	}

	// 1 ~ 100 까지 더하기
	public static void problem2() {
		System.out.println(sum(1, 100));

	}

	// for 문을 이용한 구구단 만들기
	public static void problem3() {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " x " + j + " = " + i * j);
			}
		}
	}

	// 구구단 3단에서 4의 배수를 제외하고 출력
	public static void problem4() {
		for (int i = 1; i <= 9; i++) {
			if ((3 * i) % 4 == 0) {
				continue;
			}
			System.out.println("3 x " + i + " = " + 3 * i);
		}
	}

	// 로또 번호 추출하기
	public static void problem5() {
		int[] numbers = new int[6];
		Random random = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(46);
		}
		System.out.println(Arrays.toString(numbers));
	}

	// 최소공배수 최소공약수 구하기
	public void problem6() {
		// 유클리드 호제법을 이용한 풀이
		int a = 12;
		int b = 18;

		int gcd = getGcd(a, b);
		System.out.println("최대공약수: " + gcd);

		int lcm = getLcm(a, b);
		System.out.println("최소공배수: " + lcm);

	}

	public static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

	public static int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}

	// 1000보다 작은 숫자 중 3과 5의 배수의 총합
	public static void problem7() {
		int limit = 1000;

		// 방법 1
		System.out.println(calculateMultiplesSum(3, 5, limit));

		// 방법 2
		// 15(1+2+3+...66)
		int common = getLcm(3, 5);
		System.out.println(common * sum(1, (limit - 1) / common));

	}

	private static int sum(int start, int end) {
		int partSum = start + end;
		int length = end - start + 1;
		return partSum * length / 2;
	}

	public static int calculateMultiplesSum(int num1, int num2, int limit) {
		int sum = 0;

		for (int i = 1; i < limit; i++) {
			if (i % num1 == 0 && i % num2 == 0) {
				sum += i;
			}
		}

		return sum;
	}

	@Test
	public static void addTimeTest() {
		// 기존 테스트 케이스
		Assertions.assertEquals("000100", addTime(235900, 120));
		Assertions.assertEquals("000001", addTime(235900, 61));

		Assertions.assertEquals("015900", addTime(235900, 7200)); // 2시간 추가
		Assertions.assertEquals("235901", addTime(235900, 1)); // 1초 추가
		Assertions.assertEquals("000100", addTime("000100", 86400)); // 1일(24시간) 추가
		Assertions.assertEquals("023100", addTime("000100", 9000)); // 2시간 30분 추가
		Assertions.assertEquals("000158", addTime("000100", 58)); // 58초 추가
		Assertions.assertEquals("235912", addTime(235900, 12)); // 12초 추가
		Assertions.assertEquals("000003", addTime("000001", 2)); // 2초 추가
		Assertions.assertEquals("000200", addTime("000100", 60)); // 1분 추가
		Assertions.assertEquals("235859", addTime(235900, 86399)); // 23시간 59분 59초 추가
		Assertions.assertEquals("010059", addTime("000100", 3599)); // 59분 59초 추가
		Assertions.assertEquals("235959", addTime(235900, 59)); // 59초 추가
		Assertions.assertEquals("001612", addTime("000100", 912)); // 15분 12초 추가
		Assertions.assertEquals("010600", addTime("000100", 3900)); // 1시간 5분 추가
		Assertions.assertEquals("050053", addTime("040403", 3410));




	}



	public static String addTime(int current, int addSecond) {
		return addTime(String.format("%06d", current), addSecond);
	}

	public static String addTime(String current, int addSecond) {
		int hour = Integer.parseInt(current.substring(0, 2));
		int minute = Integer.parseInt(current.substring(2, 4));
		int second = Integer.parseInt(current.substring(4, 6));

		int totalSecond = hour * 60 * 60 + minute * 60 + second + addSecond;
		int day = 60 * 60 * 23 + 60 * 59 + 60;
		if (totalSecond >= day) {
			totalSecond -= day;
		}

		int addedHour = totalSecond / 3600;
		int addedMinute = (totalSecond % 3600) / 60;
		int addedSecond = totalSecond % 60;

		return new StringBuilder()
			.append(addedHour < 10 ? "0" + addedHour : addedHour)
			.append(addedMinute < 10 ? "0" + addedMinute : addedMinute).
			append(addedSecond < 10 ? "0" + addedSecond : addedSecond).toString();
	}
}
