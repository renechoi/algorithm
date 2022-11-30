import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static int answerCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String wordOriginal = st.nextToken();		
		String wordNonCroatian = wordOriginal; 
		// wordNonCroatian은 프로그램상 redundant하여 wordOriginal과 합쳐 하나의 word 변수로 사용할 수 있지만 
		// 의미상의 명확성을 두개 변수를 각각 선언해줌 

		String[] croatians = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
		for (String croatian : croatians) {
			Matcher matcher = alphabetMatcher(wordNonCroatian, croatian);
			wordNonCroatian = calculateMatch(wordNonCroatian, matcher);
		}

		System.out.println(countNonCroatian(wordNonCroatian));
	}

	private static int countNonCroatian(String wordNonCroatian){
		return answerCount + wordNonCroatian.replace(".","").length();
	}


	private static String calculateMatch(String word, Matcher matcher) {
		if (isContainsCroatian(matcher)) {
			answerCount++;
			return calculateMatch(removeMatched(word, matcher), matcher);
		}
		return word;
	}

	private static Matcher alphabetMatcher(String word, String croatian) {
		Pattern pattern = Pattern.compile(croatian);
		return pattern.matcher(word);
	}

	private static boolean isContainsCroatian(Matcher matcher) {
		return matcher.find();
	}

	private static String removeMatched(String word, Matcher matcher) {
		String matches = matcher.pattern().toString();
		return word.replaceFirst(matches, ".");
	}
}
