import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한번에 출력하기 위한
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		// 2번째 열을 받는다
		st = new StringTokenizer(br.readLine());
		Deque<Node> myDeque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int newA = Integer.parseInt(st.nextToken());

			while (!myDeque.isEmpty() && myDeque.getLast().value > newA) {        // deque가 비어있지 않고 지금 들어온 밸류가 기존에 있던 마지막 밸류보다 작으면 마지막 밸류를 지운다. => 비어있는 경우 (처음) while문을 건너 뛴다 // + 들어왔는데 이미 최소값으로만 구성이 되어 있다면 지울 필요가 없다
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(newA, i));    // 현재 값이 들어가게 된다. // i는 0으로 들어가지만 어차피 인덱스를 위한 용도이므로 0부터 쌓여도 상관 없다

			if (myDeque.getFirst().index <= i - L) {    // 윈도우 사이즈를 벗어나게 된다면 처음 것을 삭제해준다
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();

	}


	static class Node {
		public int value;
		public int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}


}
