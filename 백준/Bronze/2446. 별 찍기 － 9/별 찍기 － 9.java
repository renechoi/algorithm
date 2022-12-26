

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

            for (int k = 1; k <= (i - 1); k++) {
                System.out.print(" ");
            }

            for (int j = N; j >= i; j--) {
                System.out.print("*");
            }

            for (int l = N - 1; l >= i; l--) {     // 0 2 4 6
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 1; i < N; i++) {

            for (int j = N - 1; j >= i + 1; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i + 1; k++) {
                System.out.print("*");
            }

            for (int l = 1; l < i + 1; l++) {   // 1 2 3 4
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
