import java.util.Scanner;
public class Main {

	/**
	 * 트라이는 트리의 부모 자식 노드 관계를 이용하되 문자열을 사정의 형태로 생성하여
	 * 문자열 검색을 수행할 수 있게 함
	 *
	 * - 문자 종류의 개수에 따라 N이 결정됨 => N진 트리
	 * - 루트 노드는 항상 공백 상태를 유지 (=빈 문자열)
	 *
	 * 트라이 자료구조로 풀이
	 * 집합 S에 속한 단어 => 트라이 구조 생성
	 * 트라이 검색을 통한 문자열 M개 포함 여부를 카운팅
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfStrings = scanner.nextInt();
		int numberOfTestStrings = scanner.nextInt();

		Node node = setUpTrieStructure(scanner, numberOfStrings);

		int count = searchUpTrieStructure(scanner, numberOfTestStrings, node);
		System.out.println(count);
	}

	private static int searchUpTrieStructure(Scanner scanner, int numberOfTestStrings, Node node) {
		int count = 0;

		while (numberOfTestStrings-->0){
			String text = scanner.next();
			Node thisNode = node;
			for (int i = 0; i < text.length(); i++) {
				char character = text.charAt(i);
				if (thisNode.child[character - 'a'] == null) {
					break;											// 공백 상태가 발견된다는 것은 일치하지 않음을 의미
				}

				thisNode = thisNode.child[character - 'a'];

				if (isLastCharacter(text, i) && thisNode.isLast)  	// 문자열의 끝까지 도달했고 마지막까지 모두 일치했다면
					count++;  										// 같은 문자열이므로 카운트
			}
		}
		return count;
	}

	private static Node setUpTrieStructure(Scanner scanner, int numberOfStrings) {
		Node node = new Node();
		while (numberOfStrings --> 0) {
			String text = scanner.next();
			Node thisNode = node;
			for (int i = 0; i < text.length(); i++) {			// 받은 텍스트의 길이 만큼 반복문 수행하여 char 추출
				char character = text.charAt(i);

				if (thisNode.child[character - 'a'] == null) {			// 아스키코드 값으로 배열 인덱스 확인
																		// character 이전의 노드가 null이라면
					thisNode.child[character - 'a'] = new Node();		// 신규 노드 생성  => 현재 문자열을 가리키는 위치의 노드가 공백이라면 신규 노등 생성하고
				}														// 아닌 경우라면 이동하여 있는데서부터 생성

				thisNode = thisNode.child[character - 'a'];				// 현재 노드에 character 할당

				if (isLastCharacter(text, i)) {
					thisNode.isLast = true;
				}
			}
		}
		return node;
	}

	private static boolean isLastCharacter(String text, int i) {
		return i == text.length() - 1;
	}
}

class Node {
	Node[] child = new Node[26];
	boolean isLast;
}
