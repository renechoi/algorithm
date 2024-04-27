class Solution {
    public int solution(int n) {
        int[] factorial = new int[13];
        factorial[0] = 1;
        
        for (int i = 1; i <= 12; i++) {
            factorial[i] = factorial[i - 1] * i;
            if (factorial[i] > n) {
                return i - 1;  // i!이 n을 초과하면, i - 1 반환
            }
        }
        
       return 12; 
    }
}