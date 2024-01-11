import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int N = parseInt(stringTokenizer.nextToken()); // students

		List<Student> students = new ArrayList<>();
		while(N-->0){
			stringTokenizer = receiveInput(bufferedReader);
			students.add(
				new Student(
					stringTokenizer.nextToken(),
					Integer.parseInt(stringTokenizer.nextToken()),
					Integer.parseInt(stringTokenizer.nextToken()),
					Integer.parseInt(stringTokenizer.nextToken())));
		}

		Collections.sort(students);

		StringBuilder stringBuilder= new StringBuilder();
		for (Student student : students) {
			stringBuilder.append(student.name).append("\n");
		}
		
		System.out.println(stringBuilder);
	}

	static class Student implements Comparable<Student> {
		String name;
		int koreanScore;
		int englishScore;
		int mathScore;

		Student(String name, int koreanScore, int englishScore, int mathScore) {
			this.name = name;
			this.koreanScore = koreanScore;
			this.englishScore = englishScore;
			this.mathScore = mathScore;
		}

		@Override
		public int compareTo(Student other) {
			int result = compareKoreanScoreDesc(other);
			if (result != 0) return result;

			result = compareEnglishScoreAsc(other);
			if (result != 0) return result;

			result = compareMathScoreDesc(other);
			if (result != 0) return result;

			return compareNameAsc(other);
		}

		private int compareKoreanScoreDesc(Student other) {
			return other.koreanScore - this.koreanScore;
		}

		private int compareEnglishScoreAsc(Student other) {
			return this.englishScore - other.englishScore;
		}

		private int compareMathScoreDesc(Student other) {
			return other.mathScore - this.mathScore;
		}

		private int compareNameAsc(Student other) {
			return this.name.compareTo(other.name);
		}
	}
}
