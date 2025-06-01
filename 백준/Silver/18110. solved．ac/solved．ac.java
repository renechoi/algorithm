
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		if (n == 0) {
			System.out.println(0);
			return;
		}

		int[] cnt = new int[31];
		for (int i = 0; i < n; i++) {
			int v = Integer.parseInt(br.readLine().trim());
			cnt[v]++;
		}

		int trim = (int) Math.round(n * 0.15); 
		int skipLow = trim;
		int skipHigh = trim;

		for (int v = 1; v <= 30 && skipLow > 0; v++) {
			int use = Math.min(skipLow, cnt[v]);
			cnt[v] -= use;
			skipLow -= use;
		}

		for (int v = 30; v >= 1 && skipHigh > 0; v--) {
			int use = Math.min(skipHigh, cnt[v]);
			cnt[v] -= use;
			skipHigh -= use;
		}

		long sum = 0;
		int remain = n - trim - trim;
		for (int v = 1; v <= 30; v++) {
			sum += (long) v * cnt[v];
		}

		System.out.println((int) Math.round((double) sum / remain));
	}

}
