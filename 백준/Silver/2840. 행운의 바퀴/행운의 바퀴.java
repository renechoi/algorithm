
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());

		char[] wheel = new char[N];
		int arrow = 0;
		int updateIdx = 0;
		while (K-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int change = Integer.parseInt(stringTokenizer.nextToken());
			char current = stringTokenizer.nextToken().charAt(0);

			if (wheel[0] == '\u0000') {
				wheel[0] = current;
				continue;
			}

			arrow += change;
			updateIdx = arrow % N;
			try {
				updateWheel(current, updateIdx, wheel);
			} catch (Exception e) {
				System.out.println("!");
				return;
			}
		}

		System.out.print(createAnswer(wheel, updateIdx));
	}


	private static String createAnswer(char[] wheel, int updateIdx) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = updateIdx; i >= 0; i--) {
			char update = wheel[i]== '\u0000' ? '?' : wheel[i];
			stringBuilder.append(update);
		}

		for (int i = wheel.length - 1; i > updateIdx; i--) {
			char update = wheel[i]== '\u0000' ? '?' : wheel[i];
			stringBuilder.append(update);
		}
		return stringBuilder.toString();
	}

	private static void updateWheel(char current, int updateIdx, char[] wheel) {

		// 같은 것이 들어있는 경우
		if (wheel[updateIdx] == current) {
			wheel[updateIdx] = current;
			return;
		}

		// 비어있는 경우  && 중복이 아닌경우
		if (wheel[updateIdx]== '\u0000' && !duplicate(current, wheel)) {
			wheel[updateIdx] = current;
			return;
		}

		// 다른 것이 들어있거나 중복인 경우
		throw new IllegalArgumentException();

	}

	private static boolean duplicate(char current, char[] wheel) {
		return IntStream.range(0, wheel.length).mapToObj(i-> wheel[i]).anyMatch(alphabet -> alphabet == current);
	}
}
