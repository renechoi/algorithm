import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 1;
		int startIdx = 1;
		int endIdx = 1;
		int sum = 1;

		while (endIdx != N) {
			if (sum == N) {
				count++;
				endIdx++;
				sum = sum + endIdx;
			} else if (sum > N) {
				sum = sum - startIdx;
				startIdx++;
			} else {
				endIdx++;
				sum = sum + endIdx;
			}
		}

		System.out.println(count);
	}
}
