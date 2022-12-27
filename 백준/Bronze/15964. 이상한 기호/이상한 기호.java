import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        System.out.println(calculate(Long.parseLong(stringTokenizer.nextToken()), Long.parseLong(stringTokenizer.nextToken())));
    }

    private static long calculate(long number1, long number2) {
        return (number1 + number2) * (number1 - number2);
    }
}
