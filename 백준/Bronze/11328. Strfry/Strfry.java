import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = bufferedReader.readLine();
		int N = Integer.parseInt(inputString);

		StringBuilder stringBuilder = new StringBuilder();

		while (N-->0){
			stringBuilder.append(각각에대해서검증하기(bufferedReader)).append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static String  각각에대해서검증하기(BufferedReader bufferedReader) throws IOException {
		int[] 알파벳배열 = new int[36];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		String 첫번째문자열 = stringTokenizer.nextToken();
		String 두번째문자열 = stringTokenizer.nextToken();

		for (char c : 첫번째문자열.toCharArray()){
			알파벳배열[알파벳을숫자로변환(c)]++;
		}

		for (char c: 두번째문자열.toCharArray()){
			알파벳배열[알파벳을숫자로변환(c)]--;
		}

		if(전부일치한다면(알파벳배열)){
			return "Possible";
		}

		return "Impossible";
	}

	private static int 알파벳을숫자로변환(char c) {
		return c -97;
	}

	private static boolean 전부일치한다면(int[] 알파벳배열) {
		return Arrays.stream(알파벳배열).allMatch(item -> item == 0);
	}
}