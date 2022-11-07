import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);		// collections 소트는 merge sort보다 향상된 소트를 수행한다.

		// 출력부
		StringBuilder sbAnswer = new StringBuilder();
		for (int number : list) {
			sbAnswer.append(number).append("\n");
		}
		System.out.println(sbAnswer);
	}
}
