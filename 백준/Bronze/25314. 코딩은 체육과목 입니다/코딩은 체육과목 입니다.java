import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number / 4; i++) {
            stringBuilder.append("long").append(" ");
        }
        stringBuilder.append("int");
        System.out.println(stringBuilder);
    }
}
