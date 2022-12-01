import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int numberOfTests = Integer.parseInt(stringTokenizer.nextToken());

		int[][] APT = initializeAPT();

		while (numberOfTests-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int floor = Integer.parseInt(stringTokenizer.nextToken());
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int roomNumber = Integer.parseInt(stringTokenizer.nextToken());

			System.out.println(getResidents(APT, floor, roomNumber));
		}
	}

	private static int[][] initializeAPT() {
		int[][] APT = new int[15][15];
		for (int i = 0; i < 15; i++) {
			APT[i][1] = 1;
			APT[0][i] = i;
		}
		return APT;
	}

	private static int getResidents(int[][] APT, int floor, int roomNumber) {
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		return APT[floor][roomNumber];
	}
}
