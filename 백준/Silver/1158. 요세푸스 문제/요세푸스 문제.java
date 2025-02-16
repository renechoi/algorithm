
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
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {




	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int N = parseInt(stringTokenizer.nextToken());
		int K = parseInt(stringTokenizer.nextToken());


		List<Integer> circle = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			circle.add(i);
		}

		StringBuilder sb = new StringBuilder();

		int index = 0;

		sb.append("<");

		while (!circle.isEmpty()) {
			index = (index + K - 1) % circle.size();
			sb.append(circle.remove(index));
			if (!circle.isEmpty()) {
				sb.append(", ");
			}
		}

		sb.append(">");
		System.out.println(sb);
	}

}
