import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("fundamentals/src/test/java/template/Boj/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int 최장길이 = -1;

		HashMap<String, 단어> map = new HashMap<>();
		단어 S = null;
		단어 T = null;

		for (int i = 0; i < N; i++) {
			String 단어내용 = br.readLine();
			단어 현재단어 = new 단어(단어내용, i);

			for (int j = 0; j < 단어내용.length(); j++) {
				String 접두사 = 단어내용.substring(0, j + 1);

				if (map.containsKey(접두사)) {
					단어 이전단어 = map.get(접두사);

					if (접두사.length() > 최장길이) {
						S = 이전단어;
						T = 현재단어;
						최장길이 = 접두사.length();
					}

					else if (접두사길이가같고(접두사, 최장길이) && 현재단어가인덱스순으로앞선다면(이전단어, S, 현재단어, T)) {

						S = 이전단어;
						T = 현재단어;
					}

				} else {
					map.put(접두사, 현재단어);
				}
			}
		}

		System.out.println(S.value);
		System.out.println(T.value);
	}

	private static boolean 접두사길이가같고(String 접두사, int 최장길이) {
		return 접두사.length() == 최장길이;
	}

	private static boolean 현재단어가인덱스순으로앞선다면(단어 이전단어, 단어 S, 단어 현재단어, 단어 T) {
		return 이전단어.index < S.index || (이전단어.index == S.index && 현재단어.index < T.index);
	}

	public static class 단어 {
		String value;
		int index;

		public 단어(String value, int index) {
			this.value = value;
			this.index = index;
		}
	}


}


