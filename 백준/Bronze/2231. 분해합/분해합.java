import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberToBeFound = Integer.parseInt(bufferedReader.readLine());
		int answer = 0;

		int generatorMin = numberToBeFound - (getDigit(numberToBeFound) * 9);
		int generatorMax = createGeneratorNumber((int) Math.pow(10, getDigit(numberToBeFound)) - 1);
		for (int i = generatorMin; i <= generatorMax; i++) {
			if (createGeneratorNumber(i) == numberToBeFound) {
				answer = i;
				break;
			}
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
			sum += String.valueOf(number).charAt(i) - 48;
		}
		return sum;
	}

}
