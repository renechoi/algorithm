import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String word = st.nextToken();

		System.out.println(getTotalTIME(word));
	}

	private static int getTotalTIME(String word) {
		int totalTime = 0;
		for (char dial : word.toCharArray()) {
			totalTime = addUpTime(totalTime, getDialTime(convertToNumber(dial)));
		}
		return totalTime;
	}

	// 이 메서드는 getTotalTime에서 char를 구할 때 리턴 타입을 int로 하면 자동 형변환이 되기 때문에
	// 삭제하여 전체 길이를 줄일 수 있지만
	// 의미상의 명확도를 위해 생존시킴
	private static int convertToNumber(char alphabet) {
		return alphabet;
	}

	private static int getDialTime(int alphabet) {
		int timeCalculated = (alphabet - 65) / 3 + 3;
		if (isFourDials(alphabet)) {
			timeCalculated--;
			return timeCalculated;
		}
		return timeCalculated;
	}

	private static boolean isFourDials(int alphabet) {
		return (char) alphabet == 'S' || alphabet == 'Y' || alphabet == 'V' || alphabet == 'Z';
	}

	private static int addUpTime(int totalTime, int time) {
		return totalTime + time;
	}
}
