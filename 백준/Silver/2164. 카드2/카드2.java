import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<Integer> answerQue = new LinkedList<>();

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++){
			answerQue.add(i);
		}

		while (answerQue.size() > 1) {
			answerQue.poll();					// 큐의 맨 위 = 맨 오른쪽
			answerQue.add(answerQue.poll());	// 위의 것이 나가고 다시 맨 위
		}
		System.out.println(answerQue.poll());
	}
}
