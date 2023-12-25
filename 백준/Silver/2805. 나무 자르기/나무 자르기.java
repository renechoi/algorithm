import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int treeCounts = Integer.parseInt(stringTokenizer.nextToken());
		int treeLengthInNeed = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int[] trees = new int[treeCounts];
		while(treeCounts-->0){
			trees[treeCounts] = Integer.parseInt(stringTokenizer.nextToken());
		}

		// 1. 절단기 높이의 탐색 범위를 정한다.
		// 2. 임의의 절단기 높이에 대해
		//   2-1. 원하는 만큼 나무를 가져갈 수 있다면 높이를 높인다.
		//   2-2. 원하는 만큼 가져갈 수 없다면 높이를 낮춘다.
		// 3. 원하는 만큼 가져갈 수 있던 높이 최대값을 출력한다.

		int l = 0;
		int r = 1000000000;
		int answer = -1;

		while (l <= r) {
			int x = (l + r) / 2;
			if (isPossible(trees, x, treeLengthInNeed)) {
				answer = x;
				l = x + 1;
			} else {
				r = x - 1;
			}
		}
		System.out.println(answer);
	}

	public static boolean isPossible(int[] trees, int cutHeight, int thresholdHeight) {
		long sum = 0;
		for (int tree : trees) {
			if (tree > cutHeight) {
				sum += tree - cutHeight;
			}
		}
		return sum >= thresholdHeight;
	}

}

