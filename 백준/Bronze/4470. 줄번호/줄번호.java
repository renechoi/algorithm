import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= testCases; i++) {
            stringBuilder.append(i).append(". ").append(bufferedReader.readLine()).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
