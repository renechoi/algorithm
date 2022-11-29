import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	private static final StringBuilder stringBuilder = new StringBuilder();
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int discs = Integer.parseInt(bufferedReader.readLine());

		stringBuilder.append((int) (Math.pow(2, discs) - 1)).append('\n');

		Hanoi(discs, 1, 2, 3);
		System.out.print(stringBuilder);
	}

	public static void Hanoi(int discs, int from, int via, int to) {
		if (discs == 1) {
			stringBuilder.append(from).append(" ").append(to).append("\n");
			return;
		}

		Hanoi(discs - 1, from, to, via);
		stringBuilder.append(from).append(" ").append(to).append("\n");
		Hanoi(discs - 1, via, from, to);
	}
}
