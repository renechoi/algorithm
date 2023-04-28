import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    
    
	public static  int MAX_VALUE = Integer.MAX_VALUE;
	public static  int MIN_VALUE = Integer.MIN_VALUE;
    
    public String solution(String stringInput) {
       String[] strings = stringInput.split(" ");
		MAX_VALUE = Integer.parseInt(strings[0]);
		MIN_VALUE = Integer.parseInt(strings[0]);

		Arrays.stream(strings).forEach(number-> {
			examineNumber(Integer.parseInt(number));
		});

		return String.format("%s %s", MIN_VALUE, MAX_VALUE);
    }
    
    
	private static void examineNumber(int number){
		if (MIN_VALUE > number){
			MIN_VALUE = number;
		}

		if (MAX_VALUE < number){
			MAX_VALUE = number;
		}
	}

}