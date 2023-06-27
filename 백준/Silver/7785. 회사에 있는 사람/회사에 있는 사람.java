
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int memberCounts = Integer.parseInt(bufferedReader.readLine());
		// List<Member> members = new LinkedList<>();

		Member[] members = new Member[memberCounts];
		int count =0;
		while (memberCounts--> 0) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String name = stringTokenizer.nextToken();
			String status = stringTokenizer.nextToken();
			members[count++] = new Member(name, status);
			// members.add(new Member(name, status));
		}

		StringBuilder stringBuilder = new StringBuilder();

		Arrays.sort(members);
		// members.sort(Member::compareTo);
		count = 1;
		for (int i =1; i< members.length; i++){
			if (members[i].equals(members[i-1]) ) {
				count++;
				continue;
			}
			if(count % 2 !=0){
				stringBuilder.append(members[i-1]).append("\n");
			}
			count =1;
		}
		if (count%2!=0){
			stringBuilder.append(members[members.length-1]);
		}

		System.out.println(stringBuilder);
	}

	static class Member implements Comparable<Member> {
		private String name;
		private String status;

		public boolean isMe(String name) {
			return name.equals(this.name);
		}

		public Member(String name, String status) {
			this.name = name;
			this.status = status;
		}

		public void updateStatus(String status) {
			this.status = status;
		}

		public boolean isAtOffice() {
			return status.equals("enter");
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(Member that) {
			return that.name.compareTo(this.name);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Member))
				return false;
			Member member = (Member)o;
			return name.equals(member.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
}


