package basic.string;

public class StringBuilderAndStringDifference {
	public static void main(String[] args) {
		final String testWord = "hello";
		long start;
		long end;

		String string = new String();
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			string += testWord;
		}
		end = System.nanoTime();
		System.out.println((end - start) / 1000000.0 + " msecs");

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			stringBuffer.append(testWord);
		}
		end = System.nanoTime();
		System.out.println((end - start) / 1000000.0 + " msecs");

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			stringBuilder.append(testWord);
		}
		end = System.nanoTime();
		System.out.println((end - start) / 1000000.0 + " msecs");

	}
}
