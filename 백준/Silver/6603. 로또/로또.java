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
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> s;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line);
			int k = Integer.parseInt(st.nextToken());
			if (k == 0){
				break;
			}

			s = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				s.add(Integer.parseInt(st.nextToken()));
			}

			sb = new StringBuilder();
			dfs(0, 0);
			System.out.println();
		}


	}

	public static void dfs(int depth, int start){
		if (depth ==6){
			System.out.println(sb.toString().trim());
			return;
		}
		for (int i = start; i < s.size(); i++) {
			int len = sb.length();
			sb.append(s.get(i)).append(' ');
			dfs(depth + 1, i + 1);
			sb.setLength(len);
		}
	}
}
