
import java.util.HashSet;

class Solution {
    static char[] 숫자들;

    static StringBuilder 현재의조합;
    static boolean[] 방문;
    static HashSet<Integer> 소수들 = new HashSet<>();

    public int solution(String numbers) {

        숫자들 = numbers.toCharArray();

        현재의조합 = new StringBuilder();
        방문 = new boolean[숫자들.length];
        소수탐색(숫자들.length,현재의조합);

        return 소수들.size();
    }

    public void 소수탐색(int depth, StringBuilder 현재의조합) {

        if(현재의조합.length() > 0) {
            int 숫자로변환 = Integer.parseInt(현재의조합.toString());
            if (isPrime(숫자로변환)) {
                소수들.add(숫자로변환);
            }
        }

        for (int i = 0; i < 숫자들.length; i++) {
            if (!방문[i]) {
                방문[i] = true;
                현재의조합.append(숫자들[i]);
                소수탐색(depth - 1, 현재의조합);
                방문[i] = false;
                현재의조합.deleteCharAt(현재의조합.length() - 1);
            }
        }



    }

    public boolean isPrime(int 숫자) {
        if (숫자 < 2) return false;
        for (int i = 2; i <= Math.sqrt(숫자); i++) {
            if (숫자 % i == 0) return false;
        }
        return true;
    }





}