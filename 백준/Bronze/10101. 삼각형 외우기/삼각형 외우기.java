import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        if (a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
            return;
        }

        if (a + b + c != 180) {
            System.out.println("Error");
            return;
        }

        if (a + b + c == 180 && isTwoAngleEquals(a, b, c)) {
            System.out.println("Isosceles");
            return;
        }

        if (a + b + c == 180 && isNothingMatches(a, b, c)) {
            System.out.println("Scalene");
        }
    }

    private static boolean isNothingMatches(int a, int b, int c) {
        return a != b && a != c && b != c;
    }

    private static boolean isTwoAngleEquals(int a, int b, int c) {
        return a == b || a == c || b == c;
    }
}
