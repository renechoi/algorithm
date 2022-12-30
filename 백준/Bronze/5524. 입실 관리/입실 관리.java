import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases-- > 0) {
            System.out.println(bufferedReader.readLine().toLowerCase());
        }
    }
}
