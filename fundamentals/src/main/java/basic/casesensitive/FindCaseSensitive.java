package basic.casesensitive;

public class FindCaseSensitive {
	public static void main(String[] args) {
		Character testCase1 = 'a';
		Character testCase2 = 'B';

		System.out.println(isLowerCase(testCase1));
		System.out.println(isUpperCase(testCase1));

		System.out.println(isLowerCase(testCase2));
		System.out.println(isUpperCase(testCase2));
	}

	public static boolean isUpperCase(Character character){
		return character < 97;
	}

	public static boolean isLowerCase(Character character){
		return character >= 97;
	}
}
