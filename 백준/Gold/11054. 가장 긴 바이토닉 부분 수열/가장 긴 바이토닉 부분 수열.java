import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] dpAsc = new int[1001];
		int[] dpDsc = new int[1001];
		int[] numbers = new int[1001];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= N; i++) {
			int number = Integer.parseInt(stringTokenizer.nextToken());
			numbers[i] = number;
			dpAsc[i] = 1;
			dpDsc[i] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (numbers[j] < numbers[i] && dpAsc[i] < dpAsc[j] + 1) {
					dpAsc[i] = dpAsc[j] + 1;

				}
			}
		}

		for (int i = N; i >= 1; i--) {
			for (int j = N; j >= i; j--) {
				if (numbers[j] < numbers[i] && dpDsc[i] < dpDsc[j] + 1) {
					dpDsc[i] = dpDsc[j] + 1;
				}
			}
		}

		int max =0;
		for (int i =0; i<=N;i++){
			if (max < dpAsc[i] + dpDsc[i]){
				max  = dpAsc[i] + dpDsc[i];
			}
		}

		System.out.println(max-1);	// 중복된 한 index를 빼주기 위해 -1
	}

}
