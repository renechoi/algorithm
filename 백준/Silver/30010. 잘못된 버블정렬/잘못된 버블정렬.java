import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());

		int[] A = new int[N];
		IntStream.range(0,N).forEach(i -> A[N-i-1] = i);
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(A).forEach(i -> stringBuilder.append(i).append(" "));
		System.out.println(stringBuilder);
	}

}