import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

	public static String solution(String string) {

		StringBuilder stringBuilder = new StringBuilder();

		IntStream.range(0, string.length()).forEach(
			i -> {
				String letter = String.valueOf(string.charAt(i));
				if (isNumber(letter)) {
					stringBuilder.append(letter);
					return;
				}
				if (i==0){
					stringBuilder.append(letter.toUpperCase());
					return;
				}
				if (isFirstLetter(letter, String.valueOf(string.charAt(i - 1)))) {
					stringBuilder.append(letter.toUpperCase());
					return;
				}
				stringBuilder.append(letter.toLowerCase());
			});

		return stringBuilder.toString();
	}

	private static boolean isFirstLetter(String letter, String previousLetter) {
		return previousLetter.equals(" ") && !letter.equals(" ") && !isNumber(letter);
	}

	private static boolean isNumber(String string) {
		return string.matches("\\d+");
	}
}