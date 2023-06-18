package basic.math;

public class PalindromicNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(747));
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome("AB"));
		System.out.println(isPalindrome("ABA"));
		System.out.println(isPalindrome("FF"));
	}

	public static boolean isPalindrome(int number){
		return isPalindrome(String.valueOf(number));
	}

	public static boolean isPalindrome(String number){
		return number.equals(new StringBuilder(number).reverse().toString());
	}

	public static boolean isPalindrome(int[] numbers){
		for (int i=0;i<numbers.length/2;i++){
			if (numbers[i] != numbers[numbers.length-1-i]){
				return false;
			}
		}
		return true;
	}


}
