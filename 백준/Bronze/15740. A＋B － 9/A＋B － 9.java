import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        BigInteger bigInteger1 = new BigInteger(stringTokenizer.nextToken());
        BigInteger bigInteger2 = new BigInteger(stringTokenizer.nextToken());

        System.out.println(bigInteger1.add(bigInteger2));
    }
}
