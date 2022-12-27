import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        double monster = Double.parseDouble(stringTokenizer.nextToken());
        double percent = Double.parseDouble(stringTokenizer.nextToken());

        monster = monster * (100 - percent) / 100;
        int answer = monster >= 100 ? 0 : 1;
        System.out.println(answer);
    }
}
