import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j >= i; j--) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.printf("%d %d %d", numbers[0], numbers[1], numbers[2]);
    }
}
