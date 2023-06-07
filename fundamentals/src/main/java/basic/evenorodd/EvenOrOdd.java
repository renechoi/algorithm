package basic.evenorodd;

public class EvenOrOdd {
	public static void main(String[] args) {

		System.out.println(isEvenOrOdd(2));
	}

	private static boolean isEven(int number){
		return number % 2 ==0;
	}

	private static boolean isOdd(int number){
		return number % 2 !=0;
	}

	private static NumberType isEvenOrOdd(int number){
		return isEven(number) ? NumberType.EVEN : NumberType.ODD;
	}



	static enum NumberType{
		EVEN, ODD;
	}
}
