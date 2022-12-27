import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int amount = Integer.parseInt(stringTokenizer.nextToken());
        System.out.printf("%d %d", case1(amount), case2(amount));
    }

    private static int case1(int amount) {
        return amount * 78 / 100;

    }

    private static int case2(int amount) {
        return (amount - (amount * 20 / 100)) +  (amount * 20 /100 ) * 78 / 100;
    }
}
