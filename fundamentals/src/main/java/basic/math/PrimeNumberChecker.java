package basic.math;

import java.util.Arrays;

public class PrimeNumberChecker {

    public static void main(String[] args) {

        System.out.println("2: " + isPrime1(2));
        System.out.println("2: " + isPrime2(2));
        System.out.println("2: " + isPrimeEratosthenes(2));
        System.out.println("3: " + isPrime1(3));
        System.out.println("3: " + isPrime2(3));
        System.out.println("3: " + isPrimeEratosthenes(3));
        System.out.println("4: " + isPrime1(4));
        System.out.println("4: " + isPrime2(4));
        System.out.println("4: " + isPrimeEratosthenes(4));
        System.out.println("5: " + isPrime1(5));
        System.out.println("5: " + isPrime2(5));
        System.out.println("5: " + isPrimeEratosthenes(5));
        System.out.println("17: " + isPrime1(17));
        System.out.println("17: " + isPrime2(17));
        System.out.println("17: " + isPrimeEratosthenes(17));
        System.out.println("22: " + isPrime1(22));
        System.out.println("22: " + isPrime2(22));
        System.out.println("22: " + isPrimeEratosthenes(22));
    }

    /**
     * 2부터 주어진 숫자보다 작은 수까지 반복문을 돌며 나누어떨어지는지 확인하므로
     * 반복문의 횟수는 주어진 숫자(number)에 비례한다.
     * 따라서 시간 복잡도 O(n)
     * @param number
     * @return
     */
    public static boolean isPrime1(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 2부터 주어진 숫자의 제곱근까지 반복문을 돌며 나누어떨어지는지 확인하므로
     * 반복문의 횟수는 주어진 숫자(number)의 제곱근에 비례한다.
     * 따라서 시간 복잡도 O(sqrt(n))
     * @param number
     * @return
     */
    public static boolean isPrime2(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 에라토스테네스의 체 알고리즘을 사용하여 주어진 범위 내의 모든 소수를 판별한다.
     * sieveOfEratosthenes 메서드의 시간 복잡도는 O(n log(log n))
     * 따라서 isPrimeEratosthenes 메서드의 시간 복잡도도 O(n log(log n))
     * @param number
     * @return
     */

    public static boolean isPrimeEratosthenes(int number) {
        if (number <= 1) {
            return false;
        }

        boolean[] primes = sieveOfEratosthenes(number);
        return primes[number];
    }

    /**
     * 소수가 되는 수의 배수를 지우면 남는 것이 소수이다.
     * @param n
     * @return
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }






}
