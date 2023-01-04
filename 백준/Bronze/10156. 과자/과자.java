import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int snackPrice = Integer.parseInt(stringTokenizer.nextToken());
        int snackCount = Integer.parseInt(stringTokenizer.nextToken());
        int currentAmount = Integer.parseInt(stringTokenizer.nextToken());

        int snackAmount = snackCount * snackPrice;

        if (currentAmount >= snackAmount) {
            System.out.println("0");
            return;
        }

        System.out.println(snackAmount - currentAmount);
    }
}
