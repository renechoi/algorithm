import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
       	Set<Integer> types = new HashSet<>();
		for (int num : nums) {
			types.add(num);
		}
		
		int max = nums.length / 2;
		return Math.min(types.size(), max);
    }
}