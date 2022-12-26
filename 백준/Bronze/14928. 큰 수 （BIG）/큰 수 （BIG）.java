import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String number = bufferedReader.readLine();

        long remainder = 0;
        for (int i = 0; i < number.length(); i++) {
            remainder = (remainder * 10 + (number.charAt(i) - '0')) % 20000303;
        }

        System.out.println(remainder);
    }
}
