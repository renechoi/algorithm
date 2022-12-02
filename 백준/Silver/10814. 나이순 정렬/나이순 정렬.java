import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfPeople = Integer.parseInt(bufferedReader.readLine());
		Member[] members = new Member[numberOfPeople];

		receiveMembers(bufferedReader, numberOfPeople, members);

		Arrays.sort(members, Comparator.comparingInt(member -> member.age));

		drawAnswer(members);
	}

	private static void drawAnswer(Member[] members) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Member member : members) {
			stringBuilder.append(member);
		}
		System.out.println(stringBuilder);
	}

	private static void receiveMembers(BufferedReader bufferedReader, int numberOfPeople, Member[] members) throws IOException {
		for (int i = 0; i < numberOfPeople; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int age = Integer.parseInt(stringTokenizer.nextToken());
			String name = stringTokenizer.nextToken();
			members[i] = Member.of(age, name);
		}
	}

	private static class Member {
		int age;
		String name;

		private Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public static Member of(int age, String name) {
			return new Member(age, name);
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
	
}
