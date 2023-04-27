class Solution {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = {};

		int denominator = lcm(denom1, denom2);

		int numerator = getNumertaor(numer1,denom1, denominator) + getNumertaor(numer2, denom2, denominator);

        return reduceFraction(numerator,denominator);
	}
    
    public static int[] reduceFraction(int numerator, int denominator) {
		int gcd = gcd(numerator, denominator);
		return new int[] {numerator / gcd, denominator / gcd};
	}


	private int getNumertaor(int numeratorOriginal, int denominatorOriginal, int denominator){
		if (denominatorOriginal / denominator ==1){
			return numeratorOriginal;
		}
		return numeratorOriginal *  denominator / denominatorOriginal;
	}


	private static int gcd(int number1, int number2){
		if (number2 ==0) {
			return number1;
		}
		return gcd(number2, number1 % number2);
	}

	private static int lcm(int number1, int number2){
		return number1 * number2 / gcd(number1, number2);
	}

}