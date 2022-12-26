
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

        int count = N;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int k = (count - 1) * 2; k > 0; k--) {
                System.out.print(" ");
            }

            for (int l = 1; l <= i; l++) {
                System.out.print("*");
            }
            System.out.println();

            count--;
        }

        count = 2;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int k = 1 ; k <= (count - 1) * 2; k++) {     // 2 4 6 8
                System.out.print(" ");
            }

            for (int l = 1; l <= i; l++) {
                System.out.print("*");
            }

            count++;

            System.out.println();
        }
    }
}