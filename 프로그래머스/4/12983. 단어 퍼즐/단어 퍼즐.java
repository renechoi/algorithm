import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        
        int n = t.length();
        int[] dp = new int[n + 1];
        int INF = 20001; 
        Arrays.fill(dp, INF);

        dp[0] = 0;
        
        for (int i =1; i<=n; i++){
            
            for (String s : strs) {
                int k = s.length();
        
                if (i >= k) {
                    if ( t.substring(i - k, i).equals(s) ) {
                        dp[i] = Math.min(dp[i], dp[i-k] + 1);
                    }       
                }
            }
        }
        
        
        
        return dp[n] == INF ? -1 : dp[n];
        
        
    }
}