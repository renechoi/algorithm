package basic.string;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MoneyFormatter {

	@Test
	public static void test() {

		System.out.println(convert3(1000));


		Assertions.assertEquals("1,000", convert(1000));
		Assertions.assertEquals("1,000", convert2(1000));
		Assertions.assertEquals("1,000", convert3(1000));
		Assertions.assertEquals("1,000", convert4(1000));
		Assertions.assertEquals("1,000", convert5(1000));
		Assertions.assertEquals("1,000", convert6(1000));

		Assertions.assertEquals("1,001", convert(1001));
		Assertions.assertEquals("1,001", convert2(1001));
		Assertions.assertEquals("1,001", convert3(1001));
		Assertions.assertEquals("1,001", convert4(1001));
		Assertions.assertEquals("1,001", convert5(1001));
		Assertions.assertEquals("1,001", convert6(1001));

		Assertions.assertEquals("1,234", convert(1234));
		Assertions.assertEquals("1,234", convert2(1234));
		Assertions.assertEquals("1,234", convert3(1234));
		Assertions.assertEquals("1,234", convert4(1234));
		Assertions.assertEquals("1,234", convert5(1234));
		Assertions.assertEquals("1,234", convert6(1234));

		Assertions.assertEquals("3,999", convert(3999));
		Assertions.assertEquals("3,999", convert2(3999));
		Assertions.assertEquals("3,999", convert3(3999));
		Assertions.assertEquals("3,999", convert4(3999));
		Assertions.assertEquals("3,999", convert5(3999));
		Assertions.assertEquals("3,999", convert6(3999));

		Assertions.assertEquals("99,999", convert(99999));
		Assertions.assertEquals("99,999", convert2(99999));
		Assertions.assertEquals("99,999", convert3(99999));
		Assertions.assertEquals("99,999", convert4(99999));
		Assertions.assertEquals("99,999", convert5(99999));
		Assertions.assertEquals("99,999", convert6(99999));

		Assertions.assertEquals("200,000", convert(200000));
		Assertions.assertEquals("200,000", convert2(200000));
		Assertions.assertEquals("200,000", convert3(200000));
		Assertions.assertEquals("200,000", convert4(200000));
		Assertions.assertEquals("200,000", convert5(200000));
		Assertions.assertEquals("200,000", convert6(200000));

		Assertions.assertEquals("1,234,567", convert(1234567));
		Assertions.assertEquals("1,234,567", convert2(1234567));
		Assertions.assertEquals("1,234,567", convert3(1234567));
		Assertions.assertEquals("1,234,567", convert4(1234567));
		Assertions.assertEquals("1,234,567", convert5(1234567));
		Assertions.assertEquals("1,234,567", convert6(1234567));

		Assertions.assertEquals("9,999,999", convert(9999999));
		Assertions.assertEquals("9,999,999", convert2(9999999));
		Assertions.assertEquals("9,999,999", convert3(9999999));
		Assertions.assertEquals("9,999,999", convert4(9999999));
		Assertions.assertEquals("9,999,999", convert5(9999999));
		Assertions.assertEquals("9,999,999", convert6(9999999));

		Assertions.assertEquals("123,456,789", convert(123456789));
		Assertions.assertEquals("123,456,789", convert2(123456789));
		Assertions.assertEquals("123,456,789", convert3(123456789));
		Assertions.assertEquals("123,456,789", convert4(123456789));
		Assertions.assertEquals("123,456,789", convert5(123456789));
		Assertions.assertEquals("123,456,789", convert6(123456789));
	}

	public static void main(String[] args) {
		test();
	}

	private static String convert(long money) {
		int digit = calculateDigit((int)money);
		StringBuilder answer = new StringBuilder();
		int count = 0;
		for (int i = 1; i < digit; i++) {
			count++;
			answer.insert(0, money % 10);
			money /= 10;
			if (count % 3 == 0) {
				answer.insert(0, ",");
			}
		}

		answer.insert(0, money);

		return answer.toString();
	}

	private static String convert2(long money) {
		int digit = calculateDigit((int)money);
		StringBuilder answer = new StringBuilder();
		Consumer<Long> consumer = n -> {
			if (answer.length() % 4 == 3) {
				answer.append(",");
			}
			answer.append(n);
		};

		reduceDigits(money, digit, consumer);

		return answer.reverse().toString();
	}

	private static void reduceDigits(long money, int digit, Consumer<Long> consumer) {
		for (int i = 1; i <= digit; i++) {
			consumer.accept(money % 10);
			money /= 10;
		}
	}

	private static String convert3(long money) {
		StringBuilder reversedMoney = new StringBuilder(String.valueOf(money)).reverse();
		String formattedMoney = IntStream.range(0, reversedMoney.length())
			.mapToObj(i -> reversedMoney.charAt(i) + ((i + 1) % 3 == 0 && i + 1 != reversedMoney.length() ? "," : ""))
			.collect(Collectors.joining());
		return new StringBuilder(formattedMoney).reverse().toString();
	}

	private static String convert4(long money) {
		String reversedMoney = new StringBuilder(String.valueOf(money)).reverse().toString();
		char[] reversedChars = reversedMoney.toCharArray();
		StringBuilder formattedMoney = new StringBuilder();
		for (int i = 0; i < reversedChars.length; i++) {
			formattedMoney.append(reversedChars[i]);
			if ((i + 1) % 3 == 0 && i + 1 != reversedChars.length) {
				formattedMoney.append(",");
			}
		}
		return formattedMoney.reverse().toString();
	}

	private static String convert5(long money) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedMoney = decimalFormat.format(money);
		return Stream.of(formattedMoney.split(""))
			.reduce("", (accumulator, value) -> accumulator + value);
	}



	public static String convert6(long money) {
		String strAmount = String.valueOf(money);
		String regex = "(\\d)(?=(\\d{3})+$)";
		String replacement = "$1,";
		return strAmount.replaceAll(regex, replacement);
	}


	private static int calculateDigit(int number) {
		if (number == 0) {
			return 1;
		}
		return (int)(Math.log10(number) + 1);

	}
}



