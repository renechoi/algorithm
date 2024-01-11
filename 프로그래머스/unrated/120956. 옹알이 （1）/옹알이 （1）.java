class Solution {
    
    public int solution(String[] babbling) {
        
        int count = 0;
        for (String word : babbling) {
            if (isValidWord(word)) {
                count++;
            }
        }
        
        return count;
    }
    
    private  boolean isValidWord(String word) {
		String[] validSounds = {"aya", "ye", "woo", "ma"};
		return checkWord(word, validSounds);
	}

	private boolean checkWord(String word, String[] validSounds) {
		if (word.isEmpty()) {
			return true;
		}

		for (String sound : validSounds) {
			if (word.startsWith(sound)) {
				return checkWord(word.substring(sound.length()), validSounds);
			}
		}

		return false;
	}
}