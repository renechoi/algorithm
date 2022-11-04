import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int checkArray[];
	static int myArray[];
	static int checkEachDnaCharacter;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		char A[] = new char[S];

		checkArray = new int[4];
		myArray = new int[4];
		checkEachDnaCharacter = 0;		// 카운트는 add와 remove 함수에서 진행되도록 한다.

		A = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < 4; i++) {
			checkArray[i] = Integer.parseInt(st.nextToken());
			if (checkArray[i] == 0)		// 모두가 0인 경우를 따지기 위함
				checkEachDnaCharacter++;
		}


		// 1번 로직 : 최초의 윈도우를 형성한다.
		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}

		if (checkEachDnaCharacter == 4)		// 0 0 0 0 인 경우 검증 필요 없이 자동으로 +1이 된다
			Result++;


		// 2번 로직 : 반복문을 돌며 윈도우의 위치를 해체했다가 다시 생성한다 = 이동한다
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkEachDnaCharacter == 4)  // A C G T 모두 만족을 해야하므로 4인 경우 +가 된다
				Result++;
		}
		System.out.println(Result);
		bf.close();
	}

	private static void Add(char c) { //새로 들어온 문자를 처리해주는 함수
		switch (c) {
			case 'A':
				myArray[0]++;
				if (myArray[0] == checkArray[0])
					checkEachDnaCharacter++;
				break;
			case 'C':
				myArray[1]++;
				if (myArray[1] == checkArray[1])
					checkEachDnaCharacter++;
				break;
			case 'G':
				myArray[2]++;
				if (myArray[2] == checkArray[2])
					checkEachDnaCharacter++;
				break;
			case 'T':
				myArray[3]++;
				if (myArray[3] == checkArray[3])
					checkEachDnaCharacter++;
				break;
		}
	}

	private static void Remove(char c) { //제거되는  문자를 처리해주는 함수
		switch (c) {
			case 'A':
				if (myArray[0] == checkArray[0])
					checkEachDnaCharacter--;
				myArray[0]--;
				break;
			case 'C':
				if (myArray[1] == checkArray[1])
					checkEachDnaCharacter--;
				myArray[1]--;
				break;
			case 'G':
				if (myArray[2] == checkArray[2])
					checkEachDnaCharacter--;
				myArray[2]--;
				break;
			case 'T':
				if (myArray[3] == checkArray[3])
					checkEachDnaCharacter--;
				myArray[3]--;
				break;
		}
	}
}
