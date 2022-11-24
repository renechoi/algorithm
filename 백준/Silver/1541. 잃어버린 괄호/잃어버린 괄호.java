import java.util.Scanner;
public class Main {
	/**
	 * 심플한 로직으로 최솟값을 구하기 위해서는 
	 * 단순하게 더하기를 모두 더해주어 가장 크게 만들어주면 된다 
	 * 더하기로 연결된 부분만 괄호를 칠 경우 모두 더해지고 
	 * 남은 연산자는 빼기만 남기 때문에 자동으로 빼기 연산이 진행된다 
	 * 
	 * 즉, 가장 큰값까지 더한 위 빼는 연산이 되므로 
	 * 풀이에 필요한 메인 로직이 된다
	 */
	
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String givenFormula = scanner.nextLine();

		String[] numbersToBeAdded = splitBetweenSubtraction(givenFormula);

		for (int number = 0; number < numbersToBeAdded.length; number++) {
			finalSummation(number, calculatedSummation(numbersToBeAdded[number]));
		}
		
		System.out.println(answer);
	}

	private static void finalSummation(int i, int calculatedSummation) {
		if (i == 0) {
			answer = answer + calculatedSummation;		// 초기 값은 더해져야 한다 = 조건에서 맨 앞 숫자는 항상 숫자 = +이기 때문에
		}
		else {
			answer = answer - calculatedSummation;
		}
	}

	private static String[] splitBetweenSubtraction(String givenFormula) {
		return givenFormula.split("-");
	}

	static int calculatedSummation(String numbersToBeAdded) {
		int sum = 0;
		String[] eachNumberToBeAdded = numbersToBeAdded.split("[+]");

		for (String number : eachNumberToBeAdded) {
			sum += Integer.parseInt(number);
		}
		
		return sum;
	}
}
