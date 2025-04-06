
import java.util.HashSet;
import java.util.Set;


class Solution {
    public int[] solution(int n, String[] words) {
		Set<String> usedWords = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			int person = (i % n) + 1;
			int turn = (i / n) + 1;

			String currentWord = words[i];
			String prevWord = (i == 0) ? null : words[i - 1];

			if (!isValidWord(currentWord, prevWord, usedWords)) {
				return new int[] {person, turn};
			}

			usedWords.add(currentWord);
		}

		return new int[] {0, 0};
	}

	private boolean isValidWord(String currentWord, String prevWord, Set<String> usedWords) {
		if (usedWords.contains(currentWord)) {
			return false;
		}

		if (prevWord != null && prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0)) {
			return false;
		}

		return true;
	}
}