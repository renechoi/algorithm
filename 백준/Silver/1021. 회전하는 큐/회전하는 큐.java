
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int 원소개수 = Integer.parseInt(st.nextToken());
		int 명령어개수 = Integer.parseInt(st.nextToken());

		Deque<Integer> 큐 = new ArrayDeque<>();
		for (int i = 1; i <= 원소개수; i++) {
			큐.addLast(i);
		}

		st = new StringTokenizer(br.readLine());
		int 연산횟수 = 0;

		while (명령어개수-- > 0) {
			int 뽑아야할숫자 = Integer.parseInt(st.nextToken());

			int idx = 타겟인덱스구하기(큐, 뽑아야할숫자);

			if (idx == 0) {
				큐.removeFirst();
				continue;
			}

			int 왼쪽이동횟수 = idx;
			int 오른쪽이동횟수 = 큐.size() - idx;
			연산횟수 += Math.min(오른쪽이동횟수, 왼쪽이동횟수);

			if (왼쪽이동횟수 <= 오른쪽이동횟수) {
				왼쪽으로이동(왼쪽이동횟수, 큐);
			} else {
				오른쪽으로이동(오른쪽이동횟수, 큐);
			}

			큐.removeFirst();
		}

		System.out.println(연산횟수);
	}

	private static int 타겟인덱스구하기(Deque<Integer> 큐, int 뽑아야할숫자) {
		int idx = 0;
		for (Integer num : 큐) {
			if (num == 뽑아야할숫자) {
				break;
			}
			idx++;
		}
		return idx;
	}

	private static void 오른쪽으로이동(int 오른쪽이동횟수, Deque<Integer> 큐) {
		for (int i = 0; i < 오른쪽이동횟수; i++) {
			큐.addFirst(큐.removeLast());
		}
	}

	private static void 왼쪽으로이동(int 왼쪽이동횟수, Deque<Integer> 큐) {
		for (int i = 0; i < 왼쪽이동횟수; i++) {
			큐.addLast(큐.removeFirst());
		}
	}
}
