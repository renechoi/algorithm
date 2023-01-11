import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= cases; i++) {
            System.out.printf("Hello World, Judge %s!\n", i);
        }
    }
}