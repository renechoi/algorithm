import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        while (count-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());
            Runnable printAction =
                    number % 2 == 0 ?
                            () -> System.out.printf("%s is even\n", number) :
                            () -> System.out.printf("%s is odd\n", number);
            printAction.run();
        }
    }
}
