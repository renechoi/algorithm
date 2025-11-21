
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] 전기용품순서 = new int[k];
		Map<Integer, Integer> 콘센트 = new HashMap<>();
		int 빼는카운트 = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			전기용품순서[i] = Integer.parseInt(st.nextToken());
		}

		// 처음(0)부터 끝까지 순회
		for (int i = 0; i < k; i++) {
			int 전기용품 = 전기용품순서[i];

			// 1. 이미 꽂혀 있으면 통과
			if (콘센트.containsKey(전기용품)) {
				continue;
			}

			// 2. 빈 자리가 있으면 그냥 꽂음
			if (콘센트.size() < n) {
				넣기(전기용품, 콘센트);
				continue;
			}

			// 3. 꽉 찼으면 -> 가장 나중에 쓰일 놈(혹은 안 쓰일 놈) 찾아서 뽑음
			int 뺄거 = 가장나중에쓰는거찾는함수(콘센트, 전기용품순서, i);

			콘센트.remove(뺄거);
			빼는카운트++;

			넣기(전기용품, 콘센트);
		}

		System.out.println(빼는카운트);
	}

	private static void 넣기(int i, Map<Integer, Integer> 콘센트) {
		콘센트.put(i, 0);
	}

	private static int 가장나중에쓰는거찾는함수(Map<Integer, Integer> 콘센트, int[] 전기용품순서, int 현재위치) {
		int 뺄거 = 0;
		int 가장먼미래 = -1;

		// 현재 콘센트에 꽂혀있는 놈들 하나씩 검사
		for (int 꽂힌거 : 콘센트.keySet()) {
			int 다음사용위치 = Integer.MAX_VALUE;

			// 현재 위치보다 뒤에 있는 순서 중에서 언제 나오나 확인
			for (int j = 현재위치 + 1; j < 전기용품순서.length; j++) {
				if (전기용품순서[j] == 꽂힌거) {
					다음사용위치 = j;
					break; // 제일 빨리 나오는 위치 찾았으면 스톱
				}
			}

			// 더 나중에 등장하는 놈이 나타나면 갱신 (아예 안 나오면 MAX_VALUE라 무조건 갱신됨)
			if (다음사용위치 > 가장먼미래) {
				가장먼미래 = 다음사용위치;
				뺄거 = 꽂힌거;
			}
		}

		return 뺄거;
	}
}