import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfPeople = Integer.parseInt(bufferedReader.readLine());

		People[] people = new People[numberOfPeople];
		for (int i = 0; i < numberOfPeople; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int weight = Integer.parseInt(stringTokenizer.nextToken());
			int height = Integer.parseInt(stringTokenizer.nextToken());
			people[i] = People.valueOf(weight, height);
		}

		int[] rank = new int[numberOfPeople];

		for (int i = 0; i < numberOfPeople; i++) {
			for (int j = 0; j < numberOfPeople; j++) {
				if (i == j) {
					continue;
				}
				if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
					rank[i] += 1;
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < numberOfPeople; i++) {
			stringBuilder.append(rank[i] + 1).append(" ");
		}
		System.out.println(stringBuilder);
	}


	private static class People {
		int weight;
		int height;

		private People(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		private static People valueOf(int weight, int height) {
			return new People(weight, height);
		}
	}
}
