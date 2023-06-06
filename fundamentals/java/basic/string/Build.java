package basic.string;

public class Build {
	public static void main(String[] args) {
		String string = buildString(new char[]{'a', 'b', 'c'});
		System.out.println("string = " + string);
	}

	public static String buildString(char[] chars){
		String newString = "";

		for (char character : chars) {
			newString += character;
		}

		return newString;
	}
}
