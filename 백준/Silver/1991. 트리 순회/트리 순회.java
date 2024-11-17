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

	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());

		Node[] nodes = new Node[27]; // 1-base 배열 사용
		for (int i = 1; i <= 26; i++) {
			nodes[i] = new Node((char)('A' + i - 1));
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			int parentIndex = parent - 'A' + 1;
			if (left != '.') {
				int leftIndex = left - 'A' + 1;
				nodes[parentIndex].left = nodes[leftIndex];
			}
			if (right != '.') {
				int rightIndex = right - 'A' + 1;
				nodes[parentIndex].right = nodes[rightIndex];
			}
		}

		StringBuilder preOrderResult = new StringBuilder();
		StringBuilder inOrderResult = new StringBuilder();
		StringBuilder postOrderResult = new StringBuilder();

		preOrder(nodes['A' - 'A' + 1], preOrderResult);
		inOrder(nodes['A' - 'A' + 1], inOrderResult);
		postOrder(nodes['A' - 'A' + 1], postOrderResult);

		System.out.println(preOrderResult.toString());
		System.out.println(inOrderResult.toString());
		System.out.println(postOrderResult.toString());
	}

	static void preOrder(Node node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append(node.data);
		preOrder(node.left, sb);
		preOrder(node.right, sb);
	}

	static void inOrder(Node node, StringBuilder sb) {
		if (node == null)
			return;
		inOrder(node.left, sb);
		sb.append(node.data);
		inOrder(node.right, sb);
	}

	static void postOrder(Node node, StringBuilder sb) {
		if (node == null)
			return;
		postOrder(node.left, sb);
		postOrder(node.right, sb);
		sb.append(node.data);
	}

}


