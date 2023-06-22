package handcoding;

import java.util.Arrays;
import java.util.Random;

public class Math1 {

	public static void main(String[] args) {
		problem5();

	}


	// 3의 배수의 합을 구하라
	public static void problem1(){
		int start = 1;
		int end = 10;

		int sum =0;
		for (int i =start; i<=end; i++){
			if ( i % 3 == 0) {
				sum+=i;
			}
		}
		System.out.println(sum);

	}


	// 1 ~ 100 까지 더하기
	public static void problem2(){
		System.out.println(sum(1, 100));

	}

	// for 문을 이용한 구구단 만들기
	public static void problem3(){
		for (int i =2; i<=9;i++){
			for (int j = 1; j<=9; j++){
				System.out.println(i +" x " + j + " = " + i*j);
			}
		}
	}

	// 구구단 3단에서 4의 배수를 제외하고 출력
	public static void problem4(){
		for (int i =1; i<=9; i++){
			if ((3 * i) % 4 ==0){
				continue;
			}
			System.out.println("3 x " + i + " = " +  3*i);
		}
	}

	// 로또 번호 추출하기
	public static void problem5(){
		int[] numbers = new int[6];
		Random random = new Random();
		for(int i =0; i<numbers.length;i++){
			numbers[i]= random.nextInt(46);
		}
		System.out.println(Arrays.toString(numbers));
	}


	// 최소공배수 최소공약수 구하기
	public void problem6(){
		// 유클리드 호제법을 이용한 풀이
		int a = 12;
		int b = 18;

		int gcd = getGcd(a, b);
		System.out.println("최대공약수: " + gcd);

		int lcm = getLcm(a, b);
		System.out.println("최소공배수: " + lcm);

	}

	public static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

	public static int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}


	// 1000보다 작은 숫자 중 3과 5의 배수의 총합
	public static void problem7(){
		int limit = 1000;

		// 방법 1
		System.out.println(calculateMultiplesSum(3, 5, limit));

		// 방법 2
		// 15(1+2+3+...66)
		int common = getLcm(3,5);
		System.out.println(common*sum(1,(limit-1)/common ));


	}

	private static int sum(int start, int end) {
		int partSum = start + end;
		int length = end - start + 1;
		return partSum * length / 2;
	}

	public static int calculateMultiplesSum(int num1, int num2, int limit) {
		int sum = 0;

		for (int i = 1; i < limit; i++) {
			if (i % num1 == 0 && i % num2 == 0) {
				sum += i;
			}
		}

		return sum;
	}
}
