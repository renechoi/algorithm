import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int numberOfTests = Integer.parseInt(stringTokenizer.nextToken());

		while (numberOfTests-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int H = Integer.parseInt(stringTokenizer.nextToken());
			int W = Integer.parseInt(stringTokenizer.nextToken());
			int person = Integer.parseInt(stringTokenizer.nextToken());
			findRoomNumber(H, W, person);
		}
	}

	private static void findRoomNumber(int H, int W, int person) {
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= H; j++) {
				int roomNumber = j * 100 + i;
				int count = ((i - 1) * H) + j;

				if (count == person) {
					System.out.println(roomNumber);
					break;
				}
			}
		}
	}
}
