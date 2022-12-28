import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int peopleCorrect = Integer.parseInt(stringTokenizer.nextToken()) * Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 5; i++) {
            System.out.print(Integer.parseInt(stringTokenizer.nextToken()) -peopleCorrect + " ");
        }
    }
}
