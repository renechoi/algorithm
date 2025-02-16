import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int j = 0; j < n; j++) {
			maxHeap.offer(new Element(matrix[n - 1][j], n - 1, j));
		}

		for (int i = 0; i < n - 1; i++) {
			Element current = maxHeap.poll();
			if (current.row > 0) {
				maxHeap.offer(new Element(matrix[current.row - 1][current.col], current.row - 1, current.col));
			}
		}

		System.out.println(maxHeap.poll().value);
	}

	static class Element implements Comparable<Element> {
		int value, row, col;

		Element(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Element o) {
			return Integer.compare(this.value, o.value);
		}
	}

}
