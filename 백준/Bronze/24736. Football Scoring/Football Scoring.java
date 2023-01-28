import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        printScore();
        printScore();
    }

    private static void printScore() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int touchDown = Integer.parseInt(stringTokenizer.nextToken());
        int fieldGoal = Integer.parseInt(stringTokenizer.nextToken());
        int safety = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(touchDown * 6 + fieldGoal * 3 + safety * 2 + p + c*2);
    }

}
