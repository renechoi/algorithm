import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		int A = Integer.parseInt(bufferedReader.readLine().trim());
		int B = Integer.parseInt(bufferedReader.readLine().trim());
		int C = Integer.parseInt(bufferedReader.readLine().trim());

		// 숫자로 계산
		int numberResult = A + B - C;

		// 문자열로 계산
		String strA = Integer.toString(A);
		String strB = Integer.toString(B);
		String strC = Integer.toString(C);

		String concatenatedStr = strA + strB;
		int strResult = Integer.parseInt(concatenatedStr) - Integer.parseInt(strC);

		System.out.println(numberResult);
		System.out.println(strResult);
	}
}
