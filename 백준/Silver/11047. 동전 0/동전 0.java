import java.util.Scanner;
public class Main {
	/**
	 * 그리디 알고리즘의 대표적인 문제로
	 * 큰 타입의 동전부터 탐색하다 조건보다 작게 되는 순간이 오면
	 * 해당 타입의 동전으로 나눠준 값의 몫을 곱하여 해당 타입을 최대한 사용해 주고 (e.g. 4200원을 구해야 하면 1000원 x 4)
	 * 나머지 금액에 대해서 위와 같은 과정을 반복한다
	 */

	private static int moneyTypeNumbers;
	private static int targetMoney;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		moneyTypeNumbers = scanner.nextInt();
		targetMoney = scanner.nextInt();
		int[] moneyTypes = getMoneyTypes(scanner);

		System.out.println(calculateMinimumTypes(moneyTypes));
	}

	private static int calculateMinimumTypes(int[] moneyTypes) {
		int typeCounts = 0;
		for (int i = moneyTypeNumbers - 1; i >= 0; i--) {		// 뒤에서부터 반복문 시작 => 큰 금액부터 검증
			if (moneyTypes[i] <= targetMoney) { 				// 현재 타입이 목표금액보다 작아진다면, 그 타입을 넣어주어야 한다
				typeCounts += (targetMoney / moneyTypes[i]);
				targetMoney = targetMoney % moneyTypes[i]; 		// 해당 타입을 넣어주면서 목표금액은 차감된다
			}
		}
		return typeCounts;
	}

	private static int[] getMoneyTypes(Scanner sc) {
		int[] moneyTypes = new int[moneyTypeNumbers];

		for (int i = 0; i < moneyTypeNumbers; i++) {
			moneyTypes[i] = sc.nextInt();
		}
		return moneyTypes;
	}
}
