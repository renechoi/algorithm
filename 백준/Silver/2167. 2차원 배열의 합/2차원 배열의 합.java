import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int column = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[row][column];
        for (int i = 0; i < row; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column; j++) {
                numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int iFind = Integer.parseInt(stringTokenizer.nextToken());
            int jFind = Integer.parseInt(stringTokenizer.nextToken());
            int xFind = Integer.parseInt(stringTokenizer.nextToken());
            int yFind = Integer.parseInt(stringTokenizer.nextToken());

            calculateSum(iFind, jFind, xFind, yFind);
        }
    }

    private static void calculateSum(int iFind, int jFind, int xFind, int yFind) {
        int sum = 0;
        for (int i = iFind - 1; i < xFind; i++) {
            for (int j = jFind - 1; j < yFind; j++) {
                sum += numbers[i][j];
            }
        }
        System.out.println(sum);
    }
}
