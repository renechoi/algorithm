import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());
        int n3 = Integer.parseInt(bufferedReader.readLine());
        int n4 = Integer.parseInt(bufferedReader.readLine());

        int sum = n1 + n2 + n3 + n4;
        int minute = sum / 60;
        int seconds = sum - minute * 60;

        System.out.println(minute);
        System.out.println(seconds);
    }
}
