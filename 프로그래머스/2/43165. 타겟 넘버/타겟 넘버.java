class Solution {
    public int solution(int[] numbers, int target) {
        int total = 0;
        for (int n : numbers){
          total += n;  
        } 

        int sumPlusTarget = total + target;
        if ((sumPlusTarget & 1) == 1 || total < target){
          return 0; // 불가능  
        } 
        int need = sumPlusTarget >> 1;   // (S + target) / 2

        int[] dp = new int[need + 1];
        dp[0] = 1;

        for (int num : numbers) {
            for (int s = need; s >= num; --s) {
                dp[s] += dp[s - num];
            }
        }
        return dp[need];
    }
}