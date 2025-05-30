
import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 0;
		String 첫번째 = br.readLine();  // n
		String 두번째 = br.readLine();  // n +1
		String 세번째 = br.readLine();  // n + 2

		if(isNumber(첫번째)) {
			System.out.println(판단함수(parseInt(첫번째)+3 ));
		} else if (isNumber(두번째)) {
			System.out.println(판단함수(parseInt(두번째)+2 ));
		} else if (isNumber(세번째)) {
			System.out.println(판단함수(parseInt(세번째)+1 ));
		} else {

		}


	}

	public static boolean isNumber(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static String 판단함수(int input){
		// 3의 배수 이면서 5의 배수 => "FizzBuzz"
		if (input % 3 == 0 && input % 5 == 0) {
			return "FizzBuzz";
		}
		// 3의 배수이지만 5의 배수가 아니면 => "Fizz"
		if (input % 3 == 0) {
			return "Fizz";
		}
		// 3의 배수가 아니지만 5의 배수면 => "Buzz"
		else if (input % 5 == 0) {
			return "Buzz";
		}
		// 3의 배수도 아니고 5의 배수도 아니면 => "None"
		else {
			return String.valueOf(input);
		}
	}
}
