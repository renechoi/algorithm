class Solution {
      // 모듈러 연산을 이용한 풀이 
      public int solution(int i, int j, int k) {
        int count = 0;
        for (int num = i; num <= j; num++) {
            int current = num;
            while (current > 0) {
                if (current % 10 == k) {
                    count++;
                }
                current /= 10;
            }
        }
        return count;
    }
}