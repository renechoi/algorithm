class Solution {
    public int solution(int n) {
        int[] A = new int[100001];
        A[0] = 0;
        A[1] = 1;

        for (int i = 0; i <= n; i++) {
            if (i == 1 || i == 0) continue;
            A[i] = ( (A[i-1] % 1234567) + (A[i-2] % 1234567) ) % 1234567;
        }
        return A[n];
    }
}