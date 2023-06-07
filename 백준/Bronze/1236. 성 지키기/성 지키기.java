
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] input = new String[N];
		char[][] castle = new char[N][M];

		for (int i = 0; i < N; i++) {
			input[i] = bufferedReader.readLine();
			for (int j = 0; j < M; j++) {
				castle[i] = toArray(input[i]);
			}
		}

		int rowCount = 0;
		for (int i=0; i< N; i++){
			for (int j=0; j<M; j++){
				if (isGuardExist(castle[i][j])){
					rowCount++;
					break;
				}
			}
		}

		int columnCount = 0;
		for (int i=0; i< M; i++){
			for (int j=0; j<N; j++){
				if (isGuardExist(castle[j][i])){
					columnCount++;
					break;
				}
			}
		}


		// System.out.println(Arrays.toString(castle[0]));
		// System.out.println(Arrays.toString(castle[1]));
		// System.out.println(Arrays.toString(castle[2]));
		// System.out.println(Arrays.toString(castle[3]));
		// System.out.println(Arrays.toString(castle[4]));
		// System.out.println(N-rowCount);
		// System.out.println(M-columnCount);
		System.out.println(N-rowCount >M-columnCount ? N-rowCount + M-columnCount - (M-columnCount) : N-rowCount + M-columnCount - (N-rowCount));
	}

	private static boolean isGuardExist(char field) {
		return field == 'X';
	}

	private static char[] toArray(String string) {
		return string.toCharArray();
	}
}


