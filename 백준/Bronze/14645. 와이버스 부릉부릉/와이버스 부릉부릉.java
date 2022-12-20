import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int number = Integer.parseInt(stringTokenizer.nextToken());
        int people = Integer.parseInt(stringTokenizer.nextToken());

        for (int i =0; i < number; i++){
            bufferedReader.readLine();
        }
        System.out.println("비와이");
    }
}