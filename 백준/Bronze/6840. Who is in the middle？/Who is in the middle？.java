import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] bears = new int[3];
        for (int i = 0; i < bears.length; i++) {
            bears[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < bears.length; i++) {
            for (int j = i; j < bears.length; j++) {
                if (i == j) {
                    continue;
                }

                if (bears[i] < bears[j]) {
                    change(bears, i, j);
                }
            }
        }

        System.out.println(bears[1]);
    }

    private static void change(int[] bears, int i, int j) {
        int temp = bears[i];
        bears[i] = bears[j];
        bears[j] = temp;
    }
}
