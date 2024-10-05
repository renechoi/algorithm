
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (좋은문장(input)) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean 좋은문장(String 문장) {
		Stack<Character> stack = new Stack<>();

		for (int i =0; i< 문장.length(); i++){
			char 알파벳 = 문장.charAt(i);

			if(stack.isEmpty()){
				stack.add(알파벳);
				continue;
			}

			if(stack.peek() == 알파벳){
				stack.pop();
				continue;
			}
			stack.add(알파벳);
		}
		return stack.isEmpty();
	}
}
