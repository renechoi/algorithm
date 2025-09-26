import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 왼쪽 끝 값
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    // 오른쪽 끝 값 (수정된 부분)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    // 중간 값
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int answer = 0;
        // 마지막 줄의 dp 값들 중에서 최댓값을 찾는다.
        for (int d : dp[triangle.length-1]) {
            answer = Math.max(answer, d);
        }
        
        return answer;
    }
}