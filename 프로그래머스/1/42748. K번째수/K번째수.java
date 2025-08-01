
import java.util.*;
import java.util.stream.Collectors;

class Solution {

	public int[] solution(int[] array, int[][] commands) {


		ArrayList<Integer> answer = new ArrayList<>();

		for (int[] command : commands) {
			int i = command[0];
			int j = command[1];
			int k = command[2];

			int[] ints = Arrays.copyOfRange(array, i - 1, j);
			Arrays.sort(ints);
			answer.add(ints[k-1]);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

  

}

