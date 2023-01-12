import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int forbidden = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= 5; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (forbidden == number) {
                count++;
            }
        }
        System.out.println(count);
    }
}