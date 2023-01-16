import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(bufferedReader.readLine());

        int A = 0;
        int B = 0;
        int C = 0;

        if (time % 10 != 0) {
            System.out.println(-1);
            return;
        }

        if (time / 300 != 0) {
            A = time / 300;
            time = time % 300;
        }

        if (time / 60 != 0) {
            B = time / 60;
            time = time % 60;
        }

        if (time / 10 != 0) {
            C = time / 10;
            time = time % 10;
        }

        System.out.printf("%d %d %d", A, B, C);
    }
}