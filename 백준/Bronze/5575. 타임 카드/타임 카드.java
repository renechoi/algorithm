import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isMinuteRounded;
    static boolean isSecondRounded;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int attendanceTime = Integer.parseInt(stringTokenizer.nextToken());
            int attendanceMinute = Integer.parseInt(stringTokenizer.nextToken());
            int attendanceSecond = Integer.parseInt(stringTokenizer.nextToken());
            int leaveTime = Integer.parseInt(stringTokenizer.nextToken());
            int leaveMinute = Integer.parseInt(stringTokenizer.nextToken());
            int leaveSecond = Integer.parseInt(stringTokenizer.nextToken());

            isSecondRounded = false;
            isMinuteRounded = false;

            int calculatedSecond = calculateSecond(attendanceSecond, leaveSecond);
            int calculatedMinute = calculateMinute(attendanceMinute, leaveMinute);
            int calculatedHour = calculateHour(attendanceTime, leaveTime);
            System.out.printf("%d %d %d \n", calculatedHour, calculatedMinute, calculatedSecond);
        }
    }

    private static int calculateSecond(int attendanceSecond, int leaveSecond) {
        if (leaveSecond - attendanceSecond < 0) {
            isSecondRounded = true;
            leaveSecond += 60;
        }

        return (leaveSecond - attendanceSecond) % 60;
    }

    private static int calculateMinute(int attendanceMinute, int leaveMinute) {
        if (isSecondRounded) {
            leaveMinute = leaveMinute - 1;
        }

        if (leaveMinute < 0) {
            isMinuteRounded = true;
            leaveMinute += 60;
        }

        if (leaveMinute - attendanceMinute < 0) {
            isMinuteRounded = true;
            leaveMinute += 60;
        }

        return (leaveMinute - attendanceMinute) % 60;
    }

    private static int calculateHour(int attendanceHour, int leaveHour) {
        if (isMinuteRounded) {
            leaveHour = leaveHour - 1;
        }
        return leaveHour - attendanceHour;
    }
}
