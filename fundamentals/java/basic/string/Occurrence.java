package basic.string;

import java.util.Arrays;

public class Occurrence {
	public static void main(String[] args) {
		int[] testCase1 = createOccurrenceArray("abcde");
		System.out.println("testCase1 = " + Arrays.toString(testCase1));
	}



	public static int[] createOccurrenceArray(String word){
		int[] occurrenceArray = new int[26];
		for (int i =0; i<word.length(); i++){
			int alphabetIndex = word.toLowerCase().charAt(i) - 'a';
			occurrenceArray[alphabetIndex]++;
		}
		return occurrenceArray;
	}


	public static int[] createOccurrenceArray2(String word) {
		int[] occurrenceArray = new int[26];
		word.toLowerCase().chars()
			.forEach(alphabet -> occurrenceArray[alphabet - 'a']++);
		return occurrenceArray;
	}

}
