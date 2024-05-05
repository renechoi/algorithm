import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        boolean[] isPrime = sieveOfEratosthenes(n);
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && n % i == 0) {
                factors.add(i);
            }
        }

        return factors.stream().mapToInt(i -> i).toArray();
    }

    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= n; j += p) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
