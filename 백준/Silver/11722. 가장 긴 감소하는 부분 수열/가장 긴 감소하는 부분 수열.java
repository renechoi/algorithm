
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i<n; i++) {
			for (int j=0; j<i; j++){
				if (A[i] < A[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} 
			}
		}
		
		int answer = 0;

		for (int i : dp) {
			answer = Math.max(answer, i);
		}
		System.out.println(answer);
	}

}