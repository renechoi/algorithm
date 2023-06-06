package basic.string;

import basic.minandmax.FindMax;
import basic.minandmax.FindMin;

public class Replace {
	public static void main(String[] args) {
		String testCase1 = "stringmycase";
		String inputString1 = "isreplaced";
		int start = 3;

		String replaced = replaceString(testCase1, inputString1, start);
		System.out.println("replaced = " + replaced);

		String testCase2 = "hello world";
		String inputString2 = "replaced";
		int start2 = 6;

		String replaced2 = replaceString(testCase2, inputString2, start2);
		System.out.println("replaced2 = " + replaced2);

		String testCase3 = "abcdefg";
		String inputString3 = "hijklmn";
		int start3 = 0;

		String replaced3 = replaceString(testCase3, inputString3, start3);
		System.out.println("replaced3 = " + replaced3);

		String testCase4 = "";
		String inputString4 = "replacement";
		int start4 = 0;

		String replaced4 = replaceString(testCase4, inputString4, start4);
		System.out.println("replaced4 = " + replaced4);

		String testCase5 = "testing";
		String inputString5 = "test";
		int start5 = 2;

		String replaced5 = replaceString(testCase5, inputString5, start5);
		System.out.println("replaced5 = " + replaced5);
	}

	private static String replaceString(String string, String inputString, int start) {
		int finalLength = calculateFinalLength(string.length(), start + inputString.length());
		char[] newCharArray = copyOriginalStringCharacters(string, finalLength);

		for (int i = start; i < calculateReplaceLength(start+inputString.length(), finalLength); i++) {
			newCharArray[i] = inputString.charAt(i - start);
		}

		return Build.buildString(newCharArray);
	}

	private static int calculateFinalLength(int initialStringLength, int withAddedString) {
		return FindMax.findMax(new int[]{initialStringLength, withAddedString});
	}

	private static int calculateReplaceLength(int replaceString, int finalLength){
		return FindMin.findMin(new int[]{replaceString, finalLength});
	}

	private static char[] copyOriginalStringCharacters(String string, int finalLength) {
		char[] newCharArray = new char[finalLength];
		for (int i = 0; i < string.length(); i++) {
			newCharArray[i] = string.charAt(i);
		}
		return newCharArray;
	}
}



