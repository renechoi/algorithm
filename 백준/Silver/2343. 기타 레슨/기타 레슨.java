import java.util.Scanner;

public class Main {

	/**
	 * 레슨 수와 블루레이 개수가 먼저 주어지고
	 * 둘째 줄에 레슨의 길이 = 시간이 주어진다
	 * <p>
	 * 풀이의 목적지는 다음과 같다
	 * 1. 시간을 전부 더한 값이 블루레이에 들어가야 한다
	 * 2. 모든 시간을 저장하는 최소 블루레이의 개수가 주어진 상황에서 크기의 최소값을 구한다
	 * <p>
	 * 예를 들어, 1 ~ 9까지의 자연수로 시간 데이터가 주어진다면
	 * 최소 시간은 9, 최대 시간은 45이다
	 * 이때 블루레이가 3개로 주어진다면
	 * 즉, 9 ~ 45 사이에서 블루레이 3개의 개수를 유지하면서 최소 크기를 만족하는
	 * 최소값을 찾는 것으로
	 * 이진 탐색을 통해 구할 수 있다 => 중앙값 크기로 모든 시간을 저장할 수 있으면 왼쪽, 없으면 오른쪽
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int lessons = scanner.nextInt();
		int numberOfBlueRays = scanner.nextInt();
		int[] lessonTimes = new int[lessons];

		int firstNumber = 0;
		int lastNumber = 0;

		for (int i = 0; i < lessons; i++) {
			lessonTimes[i] = scanner.nextInt();
			if (firstNumber < lessonTimes[i])
				firstNumber = lessonTimes[i];                                    // 레슨 최대값이 탐색 범위의 시작
			lastNumber = lastNumber + lessonTimes[i];                            // 모든 레슨의 총합이 탐색 범위의 끝
		}

		firstNumber = repeatUntilGetMinimumStartNumber(lessons, numberOfBlueRays, lessonTimes, firstNumber, lastNumber);

		System.out.println(firstNumber);
	}

	private static int repeatUntilGetMinimumStartNumber(int lessons, int numberOfBlueRays, int[] lessonTimes, int firstNumber, int lastNumber) {
		while (firstNumber <= lastNumber) {
			int middleIdx = (firstNumber + lastNumber) / 2;
			int countedBlueRay = getCountedBlueRay(lessons, lessonTimes, middleIdx);

			if (countedBlueRay > numberOfBlueRays)                                // 설정한 중간값으로 탐색한 것으로는 레슨 저장 불가
				firstNumber = middleIdx + 1;
			else
				lastNumber = middleIdx - 1;                                        // 그렇지 않다면 저장 가능하므로 내려줌
		}
		return firstNumber;
	}

	private static int getCountedBlueRay(int lessons, int[] lessonTimes, int middleIdx) {
		int lessonTimeSum = 0;                                                    // 계산중에 사용되는 레슨의 합
		int countedBlueRay = 0;                                                    // 계산중에 사용되는 카운팅된 블루레이 개수

		for (int i = 0; i < lessons; i++) {
			if (lessonTimeSum + lessonTimes[i] > middleIdx) {                    // 만약에 summation과 현재 레슨시간이 중간 인덱스보다 크면
				countedBlueRay++;                                                // 카운팅 증가, sum을 리셋으로 맞추기 => 블루레이 교체
				lessonTimeSum = 0;
			}
			lessonTimeSum = lessonTimeSum + lessonTimes[i];                        // 레슨 시간값을 늘려주어 블루레이에 저장
		}
		if (lessonTimeSum != 0)                                                    // 반복문이 종료된 이후 sum이 남아있다면 마지막 블루레이에 넣으면 된다
			countedBlueRay++;
		return countedBlueRay;
	}
}
