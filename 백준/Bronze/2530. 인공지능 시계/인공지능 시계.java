import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int time = Integer.parseInt(stringTokenizer.nextToken());
        int minute = Integer.parseInt(stringTokenizer.nextToken());
        int second = Integer.parseInt(stringTokenizer.nextToken());

        int cookingTime = Integer.parseInt(bufferedReader.readLine());

        int addUpMinute = getAddUp(second, cookingTime);
        int calculatedSecond = getCalculatedSecondOrMinute(second, cookingTime);

        int addUpTime = getAddUp(addUpMinute, minute);
        int calculatedMinute = getCalculatedSecondOrMinute(addUpMinute, minute);

        int calculatedTime = getCalculatedTime(time, addUpTime);

        System.out.printf("%d %d %d", calculatedTime, calculatedMinute, calculatedSecond);
    }

    private static int getCalculatedTime(int time, int addUpTime) {
        return (time + addUpTime) % 24;
    }

    private static int getCalculatedSecondOrMinute(int second, int cookingTime) {
        return (cookingTime + second) % 60;
    }

    private static int getAddUp(int second, int cookingTime) {
        return (cookingTime + second) / 60;
    }
}
