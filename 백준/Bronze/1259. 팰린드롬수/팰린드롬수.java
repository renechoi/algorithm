import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String number = bufferedReader.readLine();

            if (Integer.parseInt(number) == 0) {
                break;
            }

            printAnswer(isPalindrome(number));
        }
    }

    private static void printAnswer(boolean palindrome) {
        if (palindrome) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean isPalindrome(String number) {
        boolean isPalindrome = false;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == number.charAt(number.length() - 1 - i)) {  /// 0 -> 3 / 1 -> 2
                isPalindrome = true;
                continue;
            }
            isPalindrome = false;
            break;
        }
        return isPalindrome;

    }
}