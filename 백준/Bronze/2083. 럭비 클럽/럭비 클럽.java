import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();

            if ("#".equals(name)) {
                break;
            }

            int age = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            String defined = "Junior";
            if (isSenior(age, weight)) {
                defined = "Senior";
            }

            System.out.printf("%s %s\n", name, defined);
        }
    }

    private static boolean isSenior(int age, int weight) {
        return age > 17 || weight >= 80;
    }
}
