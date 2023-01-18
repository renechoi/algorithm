import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int antenna = Integer.parseInt(bufferedReader.readLine());
        int eyes = Integer.parseInt(bufferedReader.readLine());

        if (isTroyMartian(antenna, eyes)) {
            System.out.println("TroyMartian");
        }

        if (isVladSaturnian(antenna, eyes)) {
            System.out.println("VladSaturnian");
        }

        if (isGraemeMercurian(antenna, eyes)) {
            System.out.println("GraemeMercurian");
        }
    }
    
    private static boolean isTroyMartian(int antenna, int eyes) {
        return antenna >= 3 && eyes <= 4;
    }

    private static boolean isVladSaturnian(int antenna, int eyes) {
        return antenna <= 6 && eyes >= 2;
    }

    private static boolean isGraemeMercurian(int antenna, int eyes) {
        return antenna <= 2 && eyes <= 3;
    }
}