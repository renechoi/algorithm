import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String string1 = bufferedReader.readLine();
		String string2 = bufferedReader.readLine();

		int[][] dp = new int[string1.length()+1][string2.length()+1];

		for (int i = 0; i <= string1.length(); i++) {
			for (int j = 0; j <= string2.length(); j++) {
				if (i==0 || j==0) {
					dp[i][j]=0;
					continue;
				}
				if (string1.charAt(i-1) == string2.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j-1] + 1);
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);	// 위에 것 혹은 이전 것
			}
		}

//		for (int i =0; i<string1.length(); i++){
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dp[string1.length()][string2.length()]);
	}
}
