import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public int solution(int[] mats, String[][] park) {

		int[] reversedMats = Arrays.stream(mats)
			.boxed()
			.sorted(Collections.reverseOrder())
			.mapToInt(Integer::intValue)
			.toArray();

		for (int mat : reversedMats) {
			for (int x =0; x<= park.length-mat; x++) {
				for (int y =0; y<= park[0].length-mat; y++) {
					if (is정사각형가능(park, x, y, mat)) {
						return mat;
					}
				}
			}
		}

		return -1;
	}
	public boolean is정사각형가능(String[][] park, int x, int y, int len) {
		if (x + len > park.length || y + len > park[0].length) {
			return false;
		}

		for (int dx = 0; dx < len; dx++) {
			for (int dy = 0; dy < len; dy++) {
				if (점유되었다면(park[x + dx][y + dy])){
					return false;
				}
			}
		}
		return true;
	}

	private boolean 점유되었다면(String s) {
		return !s.equals("-1");
	}

}
