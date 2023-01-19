import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = getInput();

            if (input.equals("END")) {
                break;
            }

            char[] dataReversed = dataReversed(input);
            String answer = convertToString(dataReversed);
            System.out.println(formatAnswer(answer));
        }
    }

    private static String formatAnswer(String answer) {
        return answer.toCharArray()[0] == ' ' ? answer.replaceFirst(" ", "") : answer;
    }

    private static char[] dataReversed(String input) {
        char[] chars = input.toCharArray();
        char[] newChars = new char[chars.length];
        IntStream.range(0, chars.length).forEach(i -> newChars[i] = chars[chars.length - 1 - i]);
        return newChars;
    }

    private static String convertToString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, chars.length).forEach(i -> stringBuilder.append(chars[i]));
        return stringBuilder.toString();
    }

    private static String getInput() throws IOException {
        return bufferedReader.readLine();
    }
}
