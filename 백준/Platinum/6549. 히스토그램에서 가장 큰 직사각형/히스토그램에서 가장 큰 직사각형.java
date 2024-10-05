import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);

			if (n == 0) {
				break;
			}

			int[] heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = Integer.parseInt(input[i + 1]);
			}

			System.out.println(getMaxRectangleArea(heights));
		}
	}

	public static long getMaxRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		long maxArea = 0;
		int n = heights.length;

		// 히스토그램 높이를 순회하면서
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int height = heights[stack.pop()]; 
				int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
				maxArea = Math.max(maxArea, (long)height * width); 
			}
			
			stack.push(i);
		}

		// 남아 있는 직사각형 처리
		while (!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? n : n - stack.peek() - 1;
			maxArea = Math.max(maxArea, (long)height * width);
		}

		return maxArea;
	}

	

}


