import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		String stringNumber = scanner.next();
		char[] characterNumber = stringNumber.toCharArray();

		int sum = 0;
		for (int i = 0; i < characterNumber.length; i++) {
			sum += characterNumber[i] - '0';
		}
		System.out.println(sum);
	}

}