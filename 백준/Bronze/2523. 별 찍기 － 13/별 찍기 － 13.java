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

        int count = N - 1;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        for (int i = 1; i < N; i++) {

            for (int j = count; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println();
            count--;
        }
    }
}
