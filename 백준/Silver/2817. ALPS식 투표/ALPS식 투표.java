
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int participants = Integer.parseInt(bufferedReader.readLine());
		int staffCounts = Integer.parseInt(bufferedReader.readLine());

		List<Staff> staffs = new ArrayList<>();
		List<Double> scores = new ArrayList<>();
		Map<String, Integer> staffInformation = new LinkedHashMap<>();
		while (staffCounts--> 0) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String name = stringTokenizer.nextToken();
			int votes = Integer.parseInt(stringTokenizer.nextToken());
			staffInformation.put(name, votes);
		}

		for (Map.Entry<String, Integer> stringIntegerEntry : staffInformation.entrySet()) {
			String name = stringIntegerEntry.getKey();
			Integer votes = stringIntegerEntry.getValue();

			if(votes < participants * 0.05){
				continue;
			}
			Staff staff = Staff.of(name, votes);
			staffs.add(staff);
			scores.addAll(staff.getScores());
		}

		staffs.sort(Staff::compareTo);
		scores.sort(Comparator.comparingDouble(Double::doubleValue).reversed());

		for (int i = 0; i < 14; i++) {
			Double score = scores.get(i);
			staffs.stream().filter(staff -> staff.isOwn(score))
				.forEach(Staff::receiveChip);
		}

		staffs.stream().forEach(System.out::println);
	}

	static class Staff implements Comparable<Staff> {
		private String name;
		private int votes;
		private List<Double> scores;
		private int chipCounts;
		private boolean isQualified;

		public Staff(String name, int votes, List<Double> scores) {
			this.name = name;
			this.votes = votes;
			this.scores = scores;
		}

		public static Staff of(String name, int votes) {
			List<Double> list = new ArrayList<>();
			for (int i = 1; i <= 14; i++) {
				list.add((double)votes / i);
			}

			return new Staff(name, votes, list);
		}

		public boolean isOwn(Double thatScore) {
			return scores.stream().anyMatch(score -> score.equals(thatScore));
		}

		public List<Double> getScores() {
			return scores;
		}

		@Override
		public String toString() {
			return name + " " + chipCounts;
		}

		public void receiveChip() {
			chipCounts++;
		}

		public String getName() {
			return name;
		}

		public int getChipCounts() {
			return chipCounts;
		}

		@Override
		public int compareTo(Staff that) {
			return this.name.compareTo(that.getName());
		}

	}

}
