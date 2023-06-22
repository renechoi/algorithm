package handcoding;

import java.util.Arrays;
import java.util.Random;

public class Iteration1 {

	public static void main(String[] args) {
		problem10();

	}


	/* 다음을 출력해보자.
	Sssss
	sSsss
	ssSss
	sssSs
	ssssS
	sssSs
	ssSss
	sSsss
	Sssss
	*/
	public static void problem1(){
		for (int i =0; i<9; i++){
			for (int j = 0; j<5; j++){
				if (i==j) {
					System.out.print((char) ('s' -32));
					continue;
				}
				if ((i+j) % 8 ==0){
					System.out.print((char) ('s' -32));
					continue;
				}
				System.out.print('s');
			}
			System.out.println();
		}
	}

	public static void problem1_2() {
		int n = 9;
		int m = 5;
		char[][] numbers = new char[n][m];

		for (int i =0; i< n;i++){
			for (int j = 0; j < m; j++){
				numbers[i][j] = 's';
				numbers[i][Math.abs(n/2 - Math.abs((i % (n-1)) - n/2))]= 'S';
			}
		}

		for(int i =0; i< n; i++){
			for (int j =0; j<m; j++){
				System.out.print(numbers[i][j]);
			}
			System.out.println();
		}
	}




	// 10번 동안 1~10까지 랜덤한 숫자를 출력하여 중복된 숫자가 있을 경우 true, false를 리턴하라(randomQuiz)
	public static void problem2() {
		int[] saved = new int[11];

		for (int i =0; i<10; i++){
			Random random = new Random();
			saved[random.nextInt(11)]++;
		}

		for (int count : saved){
			if (count >=2){
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
		System.out.println(Arrays.toString(saved));
	}



	// anagram
	public static void problem3() {
		String test1 = "test";
		String test2 = "tset";
		String test3 = "tast";

		if (test1.chars().sum() == test2.chars().sum()){
			System.out.println("true");
		}

	}



	// 문자열 안에 문자들이 고유한 문자인지 확인
	public static void problem4() {
		String word = "aabbccd";
		int[] alphabets = new int[26];
		for (int i =0; i< word.toLowerCase().length();i++){
			alphabets[word.charAt(i)-'a']++;
		}

		for (int i =0; i< 26; i++){
			if (alphabets[i]==0){
				return;
			}
			if (alphabets[i] > 1){
				System.out.printf("%s : 고유하지 않음%n", (char) (i +'a'));
				continue;
			}
			System.out.printf("%s : 고유함%n", (char) (i +'a'));
		}
	}



	// 진법 변환
	public void problem6(){
		int N = 5;
		int B = 2;

		String answer="";
		while (N > 0){
			int digit = N % B;

			if ( digit < 10){
				answer += digit;
			} else {
				answer += (char) ('A' + digit - 10);
			}
			N /= B;

		}

		System.out.println(new StringBuilder(answer).reverse().toString());


	}




	// 문자열 역순 변환
	public static String problem8(String string){
		return new StringBuilder(string).reverse().toString();
	}




	// 문자열에 있는 단어 순서 바꾸기
	public static void problem10(){
		String string = "developer is name my stranger hello";

		String[] words = string.split(" ");
		for(int i= words.length-1; i>=0; i--){
			System.out.print(words[i] +" ");
		}
	}



}
