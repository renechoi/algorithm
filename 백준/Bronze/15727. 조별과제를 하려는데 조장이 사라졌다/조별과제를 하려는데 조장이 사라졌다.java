import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int distance = Integer.parseInt(bufferedReader.readLine());

        if (distance % 5 == 0) {
            System.out.println(distance / 5 );
        } else {
            System.out.println(distance / 5 + 1);

        }
    }
}
