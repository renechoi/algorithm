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

        int count = 0;
        while (count != N) {
            printNthStars(N);
            count++;
        }
    }

    private static void printNthStars(int N) {
        printFirstLine(N);
        System.out.println();
        printSecondLine(N);
        System.out.println();
    }

    private static void printFirstLine(int N) {
        for (int i = 1; i <= N; i++) {

            if (i % 2 == 0) {
                System.out.print(" ");
                continue;
            }
            System.out.print("*");
        }
    }

    private static void printSecondLine(int N) {
        for (int i = 1; i <= N; i++) {

            if (i % 2 == 0) {
                System.out.print("*");
                continue;
            }
            System.out.print(" ");
        }
    }
}
