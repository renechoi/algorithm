
import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		int[] parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int commandType = parseInt(st.nextToken());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			if (Command.union.isUnion(commandType)) {
				union(parent, a, b);
			} else {
				System.out.println(find(parent, a) == find(parent, b) ? "YES" : "NO");
			}
		}


	}

	public static int find(int[] parent, int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent, parent[a]);
	}

	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}



	enum Command {

		union(0),
		find(1);

		private final int commandType;

		Command(int commandType){
			this.commandType = commandType;
		}


		public boolean isUnion(int commandType) {
			return this.commandType == commandType;
		}

	}

}


