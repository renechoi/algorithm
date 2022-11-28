import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());
		ArrayList<Integer> josephusPermutation = new ArrayList<>();

		Deque<Integer> people = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}

		while (!people.isEmpty()) {
			int count = K - 1;
			josephusCalculation(count, josephusPermutation, people);
		}

		System.out.println(drawAnswer(josephusPermutation));
	}

	private static StringBuilder drawAnswer(ArrayList<Integer> josephusPermutation) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<");
		for (Integer number : josephusPermutation){
			stringBuilder.append(number);
			stringBuilder.append(", ");
		}
		stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
		stringBuilder.append(">");
		return stringBuilder;
	}

	private static void josephusCalculation(int count, ArrayList<Integer> JosephusPermutation, Deque<Integer> people) {
		while (count-- > 0) {
			people.addLast(people.poll());
		}
		JosephusPermutation.add(people.poll());
	}
}
