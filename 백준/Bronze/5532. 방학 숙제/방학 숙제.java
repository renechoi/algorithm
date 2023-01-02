import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int vacationDays = Integer.parseInt(bufferedReader.readLine());
        int koreanPages = Integer.parseInt(bufferedReader.readLine());
        int mathPages = Integer.parseInt(bufferedReader.readLine());
        int koreanCapacity = Integer.parseInt(bufferedReader.readLine());
        int mathCapacity = Integer.parseInt(bufferedReader.readLine());

        int mathPerDay = getMathPerDay(mathPages, mathCapacity);
        int koreanPerDay = getKoreaPerDay(koreanPages, koreanCapacity);

        int homeWorkDays = Math.max(mathPerDay, koreanPerDay);
        System.out.println(vacationDays - homeWorkDays);

    }

    private static int getMathPerDay(int mathPages, int mathCapacity) {
        if (mathPages % mathCapacity == 0) {
            return mathPages / mathCapacity;
        }
        return (mathPages / mathCapacity) + 1;
    }

    private static int getKoreaPerDay(int koreanPages, int koreanCapacity) {
        if (koreanPages % koreanCapacity == 0) {
            return koreanPages / koreanCapacity;
        }
        return (koreanPages / koreanCapacity) + 1;
    }
}
