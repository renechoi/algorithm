class Solution {
    public String solution(String my_string, String overwrite_string, int s) {       
        return replaceString(my_string, overwrite_string, s);
    }

    private static String replaceString(String string, String inputString, int start) {
		int finalLength = calculateFinalLength(string.length(), start + inputString.length());
		char[] newCharArray = copyOriginalStringCharacters(string, finalLength);

		for (int i = start; i < calculateReplaceLength(start+inputString.length(), finalLength); i++) {
			newCharArray[i] = inputString.charAt(i - start);
		}

		return buildString(newCharArray);
	}

	private static int calculateFinalLength(int initialStringLength, int withAddedString) {
		return findMax(new int[]{initialStringLength, withAddedString});
	}

	private static int calculateReplaceLength(int replaceString, int finalLength){
		return findMin(new int[]{replaceString, finalLength});
	}

	private static char[] copyOriginalStringCharacters(String string, int finalLength) {
		char[] newCharArray = new char[finalLength];
		for (int i = 0; i < string.length(); i++) {
			newCharArray[i] = string.charAt(i);
		}
		return newCharArray;
	}
    
    
    public static String buildString(char[] chars){
		String newString = "";

		for (char character : chars) {
			newString += character;
		}

		return newString;
	}
    
    public static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
    
    public static int findMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
    
    
}