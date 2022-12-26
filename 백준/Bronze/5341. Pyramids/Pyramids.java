import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) {
                break;
            }
            System.out.println(calculateSum(number));
        }
    }

    private static int calculateSum(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
