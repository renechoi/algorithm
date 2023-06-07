
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int testCases = Integer.parseInt(bufferedReader.readLine());

		while (testCases-->0){
			int[] students = new int[20];
			StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
			int testCaseNo = Integer.parseInt(st.nextToken());

			students[0] = Integer.parseInt(st.nextToken());
			int stepBackCount =0;
			for (int i =1; i< 20; i++){
				int student = Integer.parseInt(st.nextToken());
				students[i] =student;
				stepBackCount = compare(student, students, i - 1, stepBackCount);
			}
			// System.out.println("students = " + Arrays.toString(students));
			System.out.println(testCaseNo + " " + stepBackCount);

		}
	}


	private static int compare(int student, int[] students, int idx, int stepBackCount){
		if (idx <0){
			return stepBackCount;
		}

		if(student < students[idx]){
			students[idx+1] =students[idx];
			students[idx] = student;
			stepBackCount++;
		}


		return compare(student, students, idx-1, stepBackCount);
	}
}


