package basic.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Reverse {
	@Test
	public static void test() {
		Assertions.assertEquals(reverse("Hello"), "olleH");
		Assertions.assertEquals(reverse2("Hello"), "olleH");
		Assertions.assertEquals(reverse3("Hello"), "olleH");
		Assertions.assertEquals(reverse4("Hello"), "olleH");
	}

	public static void main(String[] args) {
		test();
	}

	/**
	 * 주어진 문자열의 길이를 N이라고 할 때, for 루프를 통해 문자열을 역순으로 생성하는 과정이 수행된다.
	 * 따라서 시간 복잡도는 O(N)
	 *
	 * StringBuilder를 사용하여 문자열을 구축한다. 이때 추가적인 메모리 사용이 필요하다.
	 * @param word
	 * @return
	 */
	public static String reverse(String word) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			stringBuilder.append(word.charAt(i));
		}

		return stringBuilder.toString();
	}

	/**
	 * 이 방법은 문자열을 문자 배열로 변환하고, 배열의 시작과 끝 인덱스를 이용하여 문자를 교환하는 방식이다.
	 * 시작 인덱스를 증가시키고 끝 인덱스를 감소시키면서 문자를 교환하며 반복한다.
	 * 이를 통해 문자열이 역순으로 뒤집힌다.
	 * 주어진 문자열을 직접 조작하므로 추가적인 메모리 사용은 없다.
	 * 시간 복잡도는 O(N)
	 * @param word
	 * @return
	 */
	public static String reverse2(String word) {
		char[] characters = word.toCharArray();
		int start = 0;
		int end = word.length() - 1;

		while (start < end) {
			swap(characters, start, end);
			start++;
			end--;
		}

		return new String(characters);
	}



	/**
	 * StringBuilder의 reverse() 메서드를 사용하여 주어진 문자열을 역순으로 변환한다.
	 * 시간 복잡도는 O(N)
	 * 메서드 체인을 통해 간결하고 직관적인 코드를 작성할 수 있다는 장점이 있다.
	 * @param word
	 * @return
	 */
	public static String reverse3(String word) {
		return new StringBuilder(word).reverse().toString();
	}

	/**
	 * 재귀적인 방식을 사용하여 주어진 문자열을 역순으로 변환헌다.
	 * 문자열의 길이를 N이라고 할 때, 재귀 호출이 N-1번 이루어지는 것을 볼 수 있다.
	 * 시간 복잡도는 O(N)
	 *
	 * 재귀 호출을 통해 문자열을 역순으로 생성하므로 메모리 사용량은 증가하지 않는다.
	 * 그러나 재귀 호출을 반복하면서 스택 공간을 사용하므로 깊은 재귀 호출이 발생할 경우 스택 오버플로우 가능성을 고려해야 한다.
	 * @param word
	 * @return
	 */

	public static String reverse4(String word) {
		if (word.isEmpty()) {
			return word;
		}

		return reverse4(word.substring(1)) + word.charAt(0);
	}

	private static void swap(char[] characters, int start, int end) {
		char temp = characters[start];
		characters[start] = characters[end];
		characters[end] = temp;
	}


}
