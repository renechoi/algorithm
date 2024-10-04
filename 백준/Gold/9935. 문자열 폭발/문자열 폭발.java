
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String 입력문자열 = br.readLine();
        String 폭발문자열 = br.readLine();

        System.out.println(removeBombs(입력문자열, 폭발문자열));
    }

    private static String removeBombs(String 입력문자열, String 폭발문자열) {
        int bombLength = 폭발문자열.length();
        StringBuilder result = new StringBuilder(); // 스택 역할을 하는 StringBuilder

        for (int i = 0; i < 입력문자열.length(); i++) {
            result.append(입력문자열.charAt(i));

            if (result.length() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (result.charAt(result.length() - bombLength + j) != 폭발문자열.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    result.delete(result.length() - bombLength, result.length());
                }
            }
        }

        return result.length() == 0 ? "FRULA" : result.toString();
    }
}