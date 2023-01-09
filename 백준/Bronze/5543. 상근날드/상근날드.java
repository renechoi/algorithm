import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int set1 = Integer.parseInt(bufferedReader.readLine());
        int set2 = Integer.parseInt(bufferedReader.readLine());
        int set3 = Integer.parseInt(bufferedReader.readLine());
        int coke = Integer.parseInt(bufferedReader.readLine());
        int sprite = Integer.parseInt(bufferedReader.readLine());

        System.out.println(findSetMin(set1, set2, set3) + findBeverageMin(coke, sprite) - 50);
    }

    private static int findSetMin(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    private static int findBeverageMin(int x, int y) {
        return Math.min(x, y);
    }
}
