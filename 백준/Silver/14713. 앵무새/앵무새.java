
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int 앵무새개수 = Integer.parseInt(br.readLine());

		ArrayList<String> 앵무새가말한문장들 = new ArrayList<>();
		while (앵무새개수-->0){
			앵무새가말한문장들.add(br.readLine());
		}

		String 검증해야하는문장 = br.readLine();

		System.out.println(가능여부판단하기(앵무새가말한문장들, 검증해야하는문장));
	}

	private static String 가능여부판단하기(ArrayList<String> 앵무새가말한문장들, String 검증해야하는문장) {

		int N = 앵무새가말한문장들.size();

		List<String>[] 앵무새문장 = new List[N];
		int[] 앵무새인덱스 = new int[N];

		for (int i = 0; i < N; i++) {
			String[] words = 앵무새가말한문장들.get(i).split("\\s+");
			앵무새문장[i] = new ArrayList<>(Arrays.asList(words));
			앵무새인덱스[i] = 0;
		}

		Map<String, Integer> 단어별앵무새맵 = new HashMap<>();

		for (int i = 0; i < N; i++) {
			if (앵무새문장[i].size() > 0) {
				String word = 앵무새문장[i].get(0);
				단어별앵무새맵.put(word, i);
			}
		}

		StringTokenizer st = new StringTokenizer(검증해야하는문장);

		while (st.hasMoreTokens()) {
			String 단어 = st.nextToken();

			if (단어별앵무새맵.containsKey(단어)) {
				int 앵무새번호 = 단어별앵무새맵.get(단어);

				앵무새인덱스[앵무새번호]++;

				단어별앵무새맵.remove(단어);

				if (앵무새인덱스[앵무새번호] < 앵무새문장[앵무새번호].size()) {
					String 다음단어 = 앵무새문장[앵무새번호].get(앵무새인덱스[앵무새번호]);
					단어별앵무새맵.put(다음단어, 앵무새번호);
				}
			} else {
				return "Impossible";
			}
		}

		for (int i = 0; i < N; i++) {
			if (앵무새인덱스[i] != 앵무새문장[i].size()) {
				return "Impossible";
			}
		}

		return "Possible";
	}


}
