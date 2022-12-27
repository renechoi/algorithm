import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(bufferedReader.readLine());

        while (testCases-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long numberA1 = Integer.parseInt(stringTokenizer.nextToken());
            long numberA2 = Integer.parseInt(stringTokenizer.nextToken());
            long numberB1 = Integer.parseInt(stringTokenizer.nextToken());
            long numberB2 = Integer.parseInt(stringTokenizer.nextToken());

            System.out.print(compareWidth(calculateWidth(numberA1, numberA2), calculateWidth(numberB1, numberB2)));
            if (testCases!=0){
                System.out.println();
            }

        }
    }

    private static String compareWidth(long euro, long tele) {
        if (euro < tele) {
            return "Eurecom";
        }
        if (tele < euro) {
            return "TelecomParisTech";
        }
        return "Tie";
    }

    private static long calculateWidth(long number1, long number2) {
        return number1 * number2;
    }
}
