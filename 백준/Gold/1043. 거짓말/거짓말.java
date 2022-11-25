import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * 문제를 이해할 때 주의해야 하는 부분은
	 * 파티가 다르더라도 진실을 아는 사람이 연결이 되어 있다면
	 * 그 사람이 없더라도 이미 연결된 사람은 진실을 알고 있다는 것이다
	 * <p>
	 * 예를 들어
	 * 4 5
	 * 1 1
	 * 1 1
	 * 1 2
	 * 1 3
	 * 1 4
	 * 2 4 1
	 * <p>
	 * 과 같은 입력에서
	 * 실제 진실을 아는 사람은 1번이지만 마지막 파티에서 4번과 1번이 같이 연결이 되어 있기 때문에
	 * 4번과 1번 모두 진실을 아는 것으로 판단되어
	 * 정답은 2가 된다
	 * <p>
	 * union find로 해결할 수 있는데
	 * 파티마다 입력되는 사람들이 같은 그래프로 묶이고
	 * 진실을 아는 사람이 같은 그래프에 있는지 확인하면 된다
	 * <p>
	 * 따라서 집합은 union을 사용하고
	 * 판별은 find를 이용한다
	 */

	public static int[] representative;
	public static int[] knowingTruth;
	public static ArrayList<Integer>[] parties;
	public static int numberOfPartiesWithLie;
	private static int numberOfPeople;
	private static int numberOfParties;

	public static void main(String[] args) {

		setup();

		groupPeople();

		checkGroup();

		System.out.println(numberOfPartiesWithLie);
	}

	private static void checkGroup() {

		/**
		 * find 연산을 통해 진실을 아는 사람들 1, 2 7이 같은 그룹에 있는지 확인
		 * => find(1), find(2), find(7)
		 *
		 * => for문을 통해 모든 파티에 대해 수행
		 *
		 * => 파티의 대표 노드가 진실을 아는 사람들과 다른 그룹에 있다면 각 파티별 for문은 종료되면서
		 * => 거짓말 할 수 있는 파티 개수 ++
		 *
		 * e.g.
		 *
		 * 파티 1)
		 * 3, 4 => find(3), find(4) => find(1) / find(2) / find(7)과 같은 그룹이 아니므로 거짓말 가능
		 *
		 * 파티 2)
		 * 5 => find(5) => 같은 로직
		 *
		 * 파티 3)
		 * 5, 6 => find(5), find(6) => 같은 로직 
		 * ...
		 *
		 *
		 */

		for (int i = 0; i < numberOfParties; i++) {
			boolean isAbleToLie = true;
			int person = parties[i].get(0);
			for (int truthKnowingPerson : knowingTruth) {
				if (find(person) == find(truthKnowingPerson)) {
					isAbleToLie = false;
					break;
				}
			}
			if (isAbleToLie)
				numberOfPartiesWithLie++;
		}
	}

	private static void groupPeople() {
		/**
		 * 파티에 참여한 사람들을 1개의 그룹으로 만들기
		 * 							1 2 3 4 5 6 7 8
		 * 2 3 4 => union(3,4)  	1 2 3 3 5 6 7 8
		 * 1 5 => 1명이므로 연산 x 	1 2 3 3 5 6 7 8
		 * 2 5 6 => union(5,6)		1 2 3 3 5 5 7 8
		 * 2 6 8 => union(6,8)		1 2 3 3 5 5 7 5
		 * 1 8 => 1명이므로 연산 x
		 *
		 * => 그루핑 결과 : 1 2 3 3 5 5 7 5
		 * 여기서 대표 노드로 초기화 되어 있음
		 */

		for (int i = 0; i < numberOfParties; i++) {
			int firstPeople = parties[i].get(0);
			for (int j = 1; j < parties[i].size(); j++) {
				union(firstPeople, parties[i].get(j));
			}
		}
	}

	private static void setup() {
		Scanner scanner = new Scanner(System.in);
		numberOfPeople = scanner.nextInt();
		numberOfParties = scanner.nextInt();
		int partyInformation = scanner.nextInt();

		saveKnowingTruth(scanner, partyInformation);
		savePartyInfo(scanner);
		initializeRepresentative();
	}

	private static void initializeRepresentative() {
		representative = new int[numberOfPeople + 1];
		for (int i = 0; i <= numberOfPeople; i++) { // 대표 노드를 자기 자신으로 초기화 하기
			representative[i] = i;
		}
	}

	private static void savePartyInfo(Scanner scanner) {
		parties = new ArrayList[numberOfParties];

		for (int party = 0; party < numberOfParties; party++) {        // 파티수 만큼 정보는 주어지므로 
			parties[party] = new ArrayList<>();
			int peopleComing = scanner.nextInt();                        // 맨 첫째로 사람 수가 주어지고 
			for (int person = 0; person < peopleComing; person++) {        // 사람 수에 이어서 오는 사람의 번호가 주어진다
				parties[party].add(scanner.nextInt());
			}
		}
	}

	private static void saveKnowingTruth(Scanner scanner, int partyInformation) {
		knowingTruth = new int[partyInformation];

		for (int i = 0; i < partyInformation; i++) { // 진실을 아는 사람 저장
			knowingTruth[i] = scanner.nextInt();
		}
	}

	public static void union(int a, int b) { // union 연산 : 바로 연결이 아닌 대표 노드끼리 연결하여 줌
		a = find(a);
		b = find(b);
		if (a != b) {
			representative[b] = a;
		}
	}

	public static int find(int a) { // find 연산
		if (a == representative[a])
			return a;
		else
			return representative[a] = find(representative[a]); // 재귀함수의 형태로 구현
	}
}
