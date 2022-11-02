
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Scores = new int[N];
		for (int i = 0; i <N; i++){
			Scores[i] = sc.nextInt();
		}

		long sum = 0;
		long max = 0;
		for (int i =0; i < N; i++){
			int Score = Scores[i];
			if (Scores[i] > max) {
				max = Score;
			}
			sum += Score;
		}
		System.out.println(sum * 100.0 / max / N);
	}
}
