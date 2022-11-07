import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력 후 배열로 보관하기
		Scanner sc = new Scanner(System.in);
		int peopleNum = sc.nextInt();
		List<Integer> waitingLine = new LinkedList<>();
		List<Integer> sortedLine = new LinkedList<>();
		for (int person =0; person < peopleNum; person++){
			waitingLine.add(person, sc.nextInt());
		}

		// 삽입정렬 알고리즘
		for (int cnt = 0; cnt < peopleNum; cnt++){
			insertSort(sortedLine, waitingLine.get(cnt));
		}

		// 합배열 알고리즘
		int[] sumArray = new int[peopleNum];
		sumArray[0] = sortedLine.get(0);
		for (int idx = 1; idx < peopleNum; idx ++){
			sumArray[idx] = sumArray[idx-1] + sortedLine.get(idx);
		}

		// 더하여 결과 출력
		int answer = 0;
		for (int idx = 0; idx < peopleNum; idx++){
			answer = answer + sumArray[idx];
		}
		System.out.println(answer);
	}

	/**
	 * 3) 삽입정렬 알고리즘을 구현한다.
	 * 로직은 다음과 같다.
	 * - 새로운 배열 (sorted)에 위에서 만든 사람별 시간을 넣되
	 * - 0부터 시작하는 인덱스를 반복하고
	 * - 만약 현재 들어가는 것이 x번째에 존재하는 값보다 크다면 그대로 들어가고
	 * - 작다면 해당 위치에 기존의 것을 밀어내면서 들어간다.
	 */
	public static void insertSort(List<Integer> sortedLine, int personTime){
		for (int idx = 0; idx < sortedLine.size(); idx++){
			if (sortedLine.get(idx) > personTime){
				sortedLine.add(idx, personTime);
				return;
			}
		}
		sortedLine.add(personTime);
	}
}
