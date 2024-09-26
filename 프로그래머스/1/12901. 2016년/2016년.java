class Solution {
    public String solution(int a, int b) {
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] start = {5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

		return week[(start[a - 1] + (b - 1)) % 7];
	}
}