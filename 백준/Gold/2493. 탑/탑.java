
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		System.out.println(풀이메서드(bufferedReader, N));
	}

	private static StringBuilder 풀이메서드(BufferedReader bufferedReader, int N) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		Stack<Top> 스택 = new Stack<>();

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int index = 0;
		while (N--> 0) {

			Top top = new Top(Integer.parseInt(stringTokenizer.nextToken()), ++index);

			if (스택이비어있음(스택)) {
				없는경우0기록하고자신을스택에추가(stringBuilder, 스택, top);
				continue;
			}

			while (스택이비어있지않음(스택) && 현재의탑이왼쪽탑보다크면(스택, top)) {
				왼쪽탑을스택에서제거(스택);
			}

			if (스택이비어있음(스택)) {
				없는경우0기록하고자신을스택에추가(stringBuilder, 스택, top);
				continue;
			}

			있는경우해당인덱스기록하고자신을스택에추가(stringBuilder, 스택, top);
		}

		return stringBuilder;
	}

	private static boolean 스택이비어있음(Stack<Top> 스택) {
		return 스택.isEmpty();
	}

	private static boolean 스택이비어있지않음(Stack<Top> 스택) {
		return !스택.isEmpty();
	}

	private static void 있는경우해당인덱스기록하고자신을스택에추가(StringBuilder stringBuilder, Stack<Top> 스택, Top top) {
		stringBuilder.append(스택.peek().index).append(" ");
		스택.add(top);
	}

	private static void 없는경우0기록하고자신을스택에추가(StringBuilder stringBuilder, Stack<Top> 스택, Top top) {
		stringBuilder.append(0).append(" ");
		스택.add(top);
	}

	public static class Top {
		private int height;
		private int index;

		public Top(int height, int index) {
			this.height = height;
			this.index = index;
		}

		public boolean isShorterThan(Top top) {
			return this.height < top.height;
		}

		public boolean isEqualOrTallerThan(Top top) {
			return !isShorterThan(top);
		}
	}

	private static void 왼쪽탑을스택에서제거(Stack<Top> 스택) {
		스택.pop();
	}

	private static boolean 현재의탑이왼쪽탑보다크면(Stack<Top> 스택, Top top) {
		return 스택.peek().isShorterThan(top);
	}
}