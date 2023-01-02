import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int sum1 = Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int sum2 = Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken())
                + Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(Math.max(sum1, sum2));
    }
}
