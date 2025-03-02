class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            // 각 라운드에서 참가자 번호는 (번호+1)/2로 갱신
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        return round;
    }
    
}
