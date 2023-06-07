package basic.string;

public class Replace2 {
	public static void main(String[] args) {
		String testCase1 = "stringmycase";
		String inputString1 = "isreplaced";
		int start = 3;
		String replaced = replace(testCase1, inputString1, start);
		System.out.println("replaced = " + replaced);

		String testCase5 = "testing";
		String inputString5 = "test";
		int start5 = 2;

		String replaced5 = replace(testCase5, inputString5, start5);
		System.out.println("replaced5 = " + replaced5);
	}
	public static String replace(String my_string, String overwriteString, int start) {
		String before = my_string.substring(0, start);
		String after = my_string.substring(start + overwriteString.length());
		return before + overwriteString + after;
	}
}
