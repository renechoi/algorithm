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
            for (int j = 1; j < N * 2 + 1; j++) {

                if (i % 2 == 0) {
                    if (j % 2 != 0) {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print("*");
                } else {
                    if (j % 2 != 0) {
                        System.out.print("*");
                        continue;
                    }
                    System.out.print(" ");
                }
            }
            
            System.out.println();
        }
    }
}
