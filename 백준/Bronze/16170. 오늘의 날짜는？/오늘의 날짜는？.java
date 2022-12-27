import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));
    }
}
