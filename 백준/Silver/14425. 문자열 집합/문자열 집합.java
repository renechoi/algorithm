
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		String[] strings = new String[N];
		while(N-->0){
			strings[N] = bufferedReader.readLine();
		}

		Arrays.sort(strings);

		int count =0;
		while(M-->0){
			if(exist(bufferedReader.readLine(), strings)){
				count++;
			}
		}

		System.out.println(count);

	}

	private static boolean exist(String word, String[] strings) {
		int left =0 ;
		int right = strings.length -1;

		while(left<=right){
			int mid = (left + right) / 2;
			if (strings[mid].equals(word)){
				return true;
			}
			if (strings[mid].compareTo(word) < 0){
				left = mid +1;
			} else if(strings[mid].compareTo(word) > 0){
				right = mid -1;
			}
		}
		return false;
	}

}
