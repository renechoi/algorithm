import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        printStar(N);
    }

    private static void printStar(int N) {
        // 별을 찍어보자

        for (int i = 1; i <= N; i++) {
            for (int j = N - 1; j >= i; j--) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (int k = 1; k < (i - 1) * 2; k++) {
                System.out.print(" ");

                if (k == ((i - 1) * 2) - 1) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }
}
