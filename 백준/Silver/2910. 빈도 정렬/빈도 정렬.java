
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int originalN = N;
		int C = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		Info[] info = new Info[N];
		int idx =0;
		while(N-->0){
			info[idx] = new Info(Integer.parseInt(stringTokenizer.nextToken()), idx++);
		}

		Arrays.sort(info);
		Occurrence[] occurrences = new Occurrence[originalN];

		int occurrenceIdx =0;
		occurrences[occurrenceIdx] = new Occurrence(info[0].number, 1, info[0].idx);
		for (int i=1; i< info.length;i++){
			if (info[i].number != info[i-1].number){
				occurrences[++occurrenceIdx] = new Occurrence(info[i].number, 1, info[i].idx);
			} else{
				occurrences[occurrenceIdx].count++;
			}
		}

		Arrays.sort(occurrences, 0, occurrenceIdx+1);

		StringBuilder stringBuilder= new StringBuilder();
		for (int i =0; i<occurrenceIdx+1;i++){
			while(occurrences[i].count>0){
				stringBuilder.append(occurrences[i].number).append(" ");
				occurrences[i].count--;
			}
		}
		System.out.println(stringBuilder);
	}

	static class Info implements Comparable<Info>{
		int number;
		int idx;

		public Info(int number, int idx) {
			this.number = number;
			this.idx = idx;
		}

		@Override
		public int compareTo(Info that) {
			if (this.number==that.number){
				return this.idx - that.idx;
			}
			return this.number- that.number;
		}
	}

	static class Occurrence implements Comparable<Occurrence>{
		int number;
		int count;
		int firstAppearance;

		public Occurrence(int number, int count, int firstAppearance) {
			this.number = number;
			this.count = count;
			this.firstAppearance = firstAppearance;
		}

		@Override
		public int compareTo(Occurrence that) {
			if (this.count==that.count){
				return this.firstAppearance - that.firstAppearance;
			}
			return that.count - this.count;
		}
	}
}
