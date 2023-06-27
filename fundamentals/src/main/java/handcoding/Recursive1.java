package handcoding;

public class Recursive1 {
	public static void main(String[] args) {
		// problem1();
		problem2();


	}


	//  재귀를 이용한 피보나치(fibo 함수)
	public static void problem1(){

		System.out.println(fiboRecursive(50));

		//
		// System.out.println(fiboRecursive(1));
		// System.out.println(fiboRecursive(2));
		// System.out.println(fiboRecursive(3));
		// System.out.println(fiboRecursive(4));
		// System.out.println(fiboRecursive(5));
		// System.out.println(fiboRecursive(6));
		// System.out.println(fiboRecursive(7));
		// System.out.println(fiboRecursive(8));




	}

	public static int fiboRecursive(int n){
		if (n==1 || n ==2){
			return 1;
		}
		return fiboRecursive(n-1) + fiboRecursive(n-2);
	}


	// 메모이제이션을 이용한 피보나치(memoFibo 함수)
	public static void problem2(){
		int n = 40;
		int[] numbers = new int[n+1];
		numbers[1] = 1;
		numbers[2] = 1;

		System.out.println(fiboDp(n, numbers));
	}

	public static int fiboDp(int n, int[] numbers){
		for (int i =3; i<=n;i++){
			numbers[i] = numbers[i-1] + numbers[i-2];
		}
		return numbers[n];
	}

	// 재귀를 이용한 팩토리얼 문제(fact 함수)
	public static void problem3(){
		System.out.println(factorial(1,1));
		System.out.println(factorial(2,1));
		System.out.println(factorial(3,1));
		System.out.println(factorial(4,1));
		System.out.println(factorial(5,1));
	}
	public static int factorial(int n, int answer){
		if (n==1){
			return answer;
		}
		answer *=n;
		return factorial(n-1, answer);

	}

	public static void problem4(){
		int n = 5;
		int[] factorials =  new int[n+1];
		factorials[1] = 1;

		System.out.println(factorialDp(n, factorials));
	}

	public static int factorialDp(int n, int[] factorials){
		for(int i =2; i<=n;i++){
			factorials[i] = factorials[i-1] * i;
		}

		return factorials[n];
	}

}
