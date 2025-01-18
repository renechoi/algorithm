
import java.util.ArrayDeque;

 class Solution {

	public int solution(String s) {

		ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String word : s.split(" ")) {
            if (word.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(word));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
	}


}
