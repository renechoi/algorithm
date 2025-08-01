
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public long solution(long n) {
         if (n == 0) {
            return 0;
        }
        
        int[] 카운트 = new int[10];

        while (n > 0) {
            카운트[(int) (n % 10) ]++;
            n /= 10;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (카운트[i] > 0) {
                stringBuilder.append(i);
                카운트[i]--;
            }
        }

        String string = stringBuilder.toString();
        return Long.parseLong(string);
    }


}

