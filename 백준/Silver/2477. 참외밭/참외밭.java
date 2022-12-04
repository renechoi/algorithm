import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int melonCounts = Integer.parseInt(bufferedReader.readLine());

		int[] melonField = new int[6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int direction = Integer.parseInt(stringTokenizer.nextToken());
			int length = Integer.parseInt(stringTokenizer.nextToken());
			melonField[i] = length;
		}

		int xMax = 0;
		int xMaxIndex = 0;
		int yMax = 0;
		int yMaxIndex = 0;

		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (melonField[i] >= xMax) {
					xMax = melonField[i];
					xMaxIndex = i;
				}
			}
			if (i % 2 != 0) {
				if (melonField[i] >= yMax) {
					yMax = melonField[i];
					yMaxIndex = i;
				}
			}
		}
		
		int xSmall = Math.abs(melonField[Math.abs(xMaxIndex + 5) % 6] - melonField[Math.abs(xMaxIndex + 1) % 6]);
		int ySmall = Math.abs(melonField[Math.abs(yMaxIndex + 5) % 6] - melonField[Math.abs(yMaxIndex + 1) % 6]);
		System.out.println((xMax * yMax - xSmall * ySmall) * melonCounts);
	}
}


