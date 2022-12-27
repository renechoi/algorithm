import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int ax = Integer.parseInt(stringTokenizer.nextToken());
        int ay = Integer.parseInt(stringTokenizer.nextToken());
        int az = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int cx = Integer.parseInt(stringTokenizer.nextToken());
        int cy = Integer.parseInt(stringTokenizer.nextToken());
        int cz = Integer.parseInt(stringTokenizer.nextToken());

        System.out.printf("%d %d %d", cx - az, cy / ay, cz - ax);
    }
}
