import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N]; // N의 개수 만큼이 들어오므로

		// 2번째 입력을 저장한다
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int ascendingNumber = 1;
		boolean result = true;

		for (int currentNumber : A) {    // N이 개수이므로
			if (currentNumber >= ascendingNumber) {            // 현재값이 오름차순으로 설정된 값보다 크다면 넣는다
				while (currentNumber >= ascendingNumber) {
					stack.push(ascendingNumber++);
					sb.append("+\n");
				}
				stack.pop();                                // 여기서 빼는 작업은 오름차순을 맞추어주는 효과를 갖는다.
				sb.append("-\n");
			} else {        // 현재값이 오름차순으로 설정된 값보다 작다면 꺼낸다.
				int poppedNumber = stack.pop();        // 여기서 빼는 값은 반드시 현재 값과 같아져야 한다. 예시에서 3의 순서에서 4가 빠지면서 NO가 출력되는 원리.

				if (poppedNumber > currentNumber) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					sb.append("-\n");
				}

			}
		}
		if (result) {
			System.out.println(sb);

		}
	}
}
