package basic.casesensitive;

public class ConvertToCase {
	public static void main(String[] args) {
		Character testCase1 = 'a';
		Character testCase2 = 'B';

		System.out.println(convert(testCase2));
		System.out.println(convert(testCase1));
	}

	private static Character convert(Character character){
		return FindCaseSensitive.isUpperCase(character) ? toLowerCase(character) : toUpperCase(character);
	}

	private static Character toUpperCase(Character character){
		return  (char)(character - 32);
	}

	private static Character toLowerCase(Character character){
		return  (char)(character + 32);
	}
}
