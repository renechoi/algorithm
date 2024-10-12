

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int 사람수 = Integer.parseInt(br.readLine());

		System.out.println(당첨자구하기(사람수));

	}

	// private static int 당첨자구하기(int 사람수) {
	//
	// 	ArrayDeque<Integer> 원형큐 = new ArrayDeque<>();
	//
	// 	for (int i = 1; i <= 사람수; i++) {
	// 		원형큐.add(i);
	// 	}
	//
	// 	단계 단계 = new 단계(1);
	// 	while (원형큐.size() > 1) {
	//
	// 		단계.단계별횟수차감();
	// 		if (단계.단계별횟수 == 0) {
	// 			원형큐.pop();
	// 			단계.단계업();
	// 		} else {
	// 			원형큐.add(원형큐.pop());
	// 		}
	// 	}
	//
	// 	return 원형큐.pop();
	// }

	private static int 당첨자구하기(int 사람수) {
		ArrayDeque<Integer> 원형큐 = new ArrayDeque<>();
		for (int i = 1; i <= 사람수; i++) {
			원형큐.add(i);
		}

		long 현재위치 = 0;
		단계 단계 = new 단계(1);

		while (원형큐.size() > 1) {
			현재위치 = (현재위치 + 단계.단계별횟수 - 1) % 원형큐.size();

			// 큐에서 해당 위치만큼 이동한 후 제거 (앞으로 빼오기)
			for (int i = 0; i < 현재위치; i++) {
				원형큐.addLast(원형큐.removeFirst());
			}

			원형큐.poll();


			현재위치 = 0; // 위치가 하나 줄어들었으므로 현재 위치는 0으로 리셋

			단계.단계업();
		}

		return 원형큐.poll();
	}


	// private static int 당첨자구하기(int 사람수) {
	// 	ArrayList<Integer> 참가자 = new ArrayList<>();
	// 	for (int i = 1; i <= 사람수; i++) {
	// 		참가자.add(i);
	// 	}
	//
	// 	int 현재위치 = 0;
	// 	단계 단계 = new 단계(1);
	//
	// 	while (참가자.size() > 1) {
	// 		현재위치 = (현재위치 + 단계.단계별횟수 - 1) % 참가자.size();
	// 		참가자.remove(현재위치); // 해당 위치에 있는 참가자를 바로 빼주기
	// 		단계.단계업();
	// 	}
	//
	// 	return 참가자.get(0); 		// 마지막 남은 참가자의 번호 반환
	// }


	public static class 단계 {
		private int 단계;
		private long 단계별횟수;

		public 단계(int 단계) {
			this.단계 = 단계;
			this.단계별횟수 = get단계별횟수(단계);
		}

		private long get단계별횟수(int 단계) {
			return (long) 단계 * 단계 * 단계;
		}

		public void 단계별횟수차감() {
			this.단계별횟수--;
		}

		public void 단계업() {
			this.단계++;
			this.단계별횟수 = get단계별횟수(단계);
		}
	}


}
