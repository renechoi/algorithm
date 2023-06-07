package basic.string;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String word1 = "listen";
		String word2 = "silent";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

		word1 = "listen";
		word2 = "silentt";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

		word1 = "triangle";
		word2 = "integral";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

		word1 = "abcdefg";
		word2 = "gfedcba";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

		word1 = "listen";
		word2 = "sileta";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

		word1 = "test";
		word2 = "tast";
		printTestResult(word1, word2,  Anagram.isAnagram(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram2(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram3(word1, word2));
		printTestResult(word1, word2,  Anagram.isAnagram4(word1, word2));

	}

	private static boolean isAnagram(String word1, String word2) {
		if (!isSameLength(word1, word2)) {
			return false;
		}

		for (int i = 0; i < word1.length(); i++) {
			if (!word2.contains(String.valueOf(word1.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAnagram2(String word1, String word2) {
		if (!isSameLength(word1, word2)) {
			return false;
		}

		int[] count1 = new int[26]; // 알파벳 개수만큼 배열 생성
		int[] count2 = new int[26];

		for (int i = 0; i < word1.length(); i++) {
			count1[word1.toLowerCase().charAt(i) - 'a']++; // 해당 문자의 개수 증가
			count2[word2.toLowerCase().charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}

		return true;
	}

	private static boolean isAnagram3(String word1, String word2) {
		if (!isSameLength(word1, word2)) {
			return false;
		}

		char[] charArray1 = word1.toCharArray();
		char[] charArray2 = word2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		return Arrays.equals(charArray1, charArray2);
	}

	private static boolean isAnagram4(String word1, String word2) {
		return calculateAsciiValueSum(word1) == calculateAsciiValueSum(word2);
	}

	private static boolean isSameLength(String word1, String word2) {
		return word1.length() == word2.length();
	}


	private static int calculateAsciiValueSum(String word){
		int sum = 0;
		for (char character : word.toCharArray()) {
			sum += character;
		}
		return sum;
	}

	private static int calculateAsciiValueSum2(String word) {
		return word.chars().sum();
	}

	private static void printTestResult(String word1, String word2, boolean actual) {
		System.out.println("Word1: " + word1 + ", Word2: " + word2 + " => " + actual);
	}
}





