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

	static int N;
	static int K;
	static int[] arr;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[N];
		stringTokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		System.out.println(삽입정렬());
	}

	public static int 삽입정렬(){
		for (int i = 1; i < N; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				count++;
				if(count == K){
					return arr[j + 1];
				}
				j--;
			}
			if (j + 1 != i) {{
				arr[j + 1] = key;
				count++;
				if(count == K){
					return key;
				}
			}}

		}
		return -1;

	}


}