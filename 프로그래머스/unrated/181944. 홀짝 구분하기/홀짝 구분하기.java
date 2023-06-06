import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isEvenOrOdd(n));
    }
    
    private static boolean isEven(int number){
		return number % 2 ==0;
	}

	private static boolean isOdd(int number){
		return number % 2 !=0;
	}

	private static String isEvenOrOdd(int number){
		return isEven(number) ? String.format("%d is even", number) : String.format("%d is odd", number);
	}
}