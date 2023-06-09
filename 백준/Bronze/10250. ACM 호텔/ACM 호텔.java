
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bufferedReader.readLine());

		while (T-->0){
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			int H = Integer.parseInt(stringTokenizer.nextToken());
			int W = Integer.parseInt(stringTokenizer.nextToken());
			int N = Integer.parseInt(stringTokenizer.nextToken());

			int floor = N % H == 0? H * 100 : (N % H) * 100;
			int room = N % H == 0 ? (N / H) : (N / H) + 1;

			System.out.println(floor+room);
		}
	}
}