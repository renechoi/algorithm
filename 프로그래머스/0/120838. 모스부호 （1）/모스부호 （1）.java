import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

class Solution {
	private static final Map<String, String> morse = new HashMap<>();

	static {
		String[] morseCodes = {
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
			"..-", "...-", ".--", "-..-", "-.--", "--.."
		};
		for (int i = 0; i < morseCodes.length; i++) {
			morse.put(morseCodes[i], createAlphabetAsString(i));
		}
	}
    
    private static String createAlphabetAsString(int i) {
		return String.valueOf((char)('a' + i));
	}

	public String solution(String letter) {
		return Arrays.stream(letter.split(" "))
			.map(morse::get) 
			.collect(Collectors.joining());  
	}

}
