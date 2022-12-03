import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> generatorNumber2 = new ArrayList<>(1000001);
		for (int i = 0; i < 1000001; i++) {
			generatorNumber2.add(i, createGeneratorNumber(i));
		}

		int answer = generatorNumber2.indexOf(Integer.parseInt(bufferedReader.readLine()));
		if (answer == -1) {
			answer = 0;
		}
		System.out.println(answer);
	}


	private static int getDigit(int number) {
		return String.valueOf(number).length();
	}

	private static int createGeneratorNumber(int number) {
		if (number < 10) {
			return number * 2;
		}
		return number + digitSum(number);
	}

	private static int digitSum(int number) {
		int sum = 0;
		for (int i = 0; i < getDigit(number); i++) {
			sum += String.valueOf(number).charAt(i)-48;
		}
		return sum;
	}
}
