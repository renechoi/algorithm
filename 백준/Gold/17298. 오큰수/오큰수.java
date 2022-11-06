import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();

		int N = sc.nextInt();
		int[] numbers = new int[N];

		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		for(int i = 0; i < N; i++) {
			// 스택이 비어 있으면 push를 한다 => 그렇지 않은 경우 반복문 형성
			// 스택의 맨 위 수로부터 판단되는 수열의 수가 현재 수보다 작다면 => 오큰수라면 => 바꿔준다
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				numbers[stack.pop()] = numbers[i];
			}

			stack.push(i);
		}

		// 반복문이 끝났으므로 아직 idx 스택에 남아있는 요소를 가져와
		// 수열의 자리에 -1로 저장 = 초기화한다

		while(!stack.isEmpty()) {
			numbers[stack.pop()] = -1;
		}

		StringBuilder sbAnswer = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sbAnswer.append(numbers[i]).append(' ');
		}

		System.out.println(sbAnswer);
	}
}
