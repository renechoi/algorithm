import java.math.BigInteger;

/**
* 팩토리얼을 직접 계산하는 방식 
* cf. DP 방식
*/
class Solution {
    public BigInteger solution(int balls, int share) {
        return combination(balls, share);
    }
    
    private BigInteger combination(int n, int k) {
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
    }
    
    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
