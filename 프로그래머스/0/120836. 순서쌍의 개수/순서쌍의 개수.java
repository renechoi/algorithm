class Solution {
    public int solution(int n) {
        return countOrderedPairs(n);
    }

    private int countOrderedPairs(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (isDivisor(n, i)) {
                answer += updateAnswer(n, i);
            }
        }
        return answer;
    }

    /**
     * 순서쌍을 구하는 데 필요한 결과 값을 업데이트합니다. 만약 'i'가 'n'의 완전 제곱근이라면, 순서쌍이 중복되므로
     * 결과 값에 1을 더합니다. 그렇지 않다면 순서쌍은 (i, n/i)와 (n/i, i) 두 가지이므로 결과 값에 2를 더합니다.
     * 
     * @param n 주어진 자연수
     * @param i 현재 검사하는 수
     * @return 순서쌍의 개수를 업데이트한 값
     */
    private int updateAnswer(int n, int i) {
        return (i * i == n) ? 1 : 2;
    }

    private boolean isDivisor(int n, int i) {
        return n % i == 0;
    }
}
