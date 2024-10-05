import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		System.out.println(createAnswer(input));
	}

	public static String createAnswer(String 문장) {
		Stack<Character> stack = new Stack<>();
		StringBuilder output = new StringBuilder();


		boolean 태그오픈 = false;
		for(int i = 0; i<문장.length(); i++){
			char 알파벳 = 문장.charAt(i);

			if(알파벳 == '<'){
				스택에서꺼내서결과문장에추가(stack, output);
				태그오픈 = true;
				output.append(알파벳);
				continue;
			}

			if (알파벳 =='>'){
				태그오픈 = false;
				output.append(알파벳);
				continue;
			}

			if(태그오픈){
				output.append(알파벳);
				continue;
			}

			if (알파벳 == ' ') {
				while (!stack.isEmpty()) {
					output.append(stack.pop());
				}
				output.append(알파벳);
				continue;
			}

			stack.add(알파벳);
		}

		문장끝에남은단어를처리(stack, output);

		return output.toString();

	}

	private static void 문장끝에남은단어를처리(Stack<Character> stack, StringBuilder output) {
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}
	}

	private static void 스택에서꺼내서결과문장에추가(Stack<Character> stack, StringBuilder output) {
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}
	}
}