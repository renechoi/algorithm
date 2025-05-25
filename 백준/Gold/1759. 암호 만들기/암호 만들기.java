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

	static int L;
	static int C;
	static char[] 가능한알파벳들;
	static final Set<Character> 모음 = Set.of('a', 'e', 'i', 'o', 'u');
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		L = parseInt(stringTokenizer.nextToken());
		C = parseInt(stringTokenizer.nextToken());
		가능한알파벳들 = new char[C];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < C; i++) {
			가능한알파벳들[i] = stringTokenizer.nextToken().charAt(0);
		}
		Arrays.sort(가능한알파벳들);

		dfs(0, 0, 0);
	}

    public static void dfs(int start, int depth, int 모음카운트) {
		if (!isPromising(depth, 모음카운트)) {
            return;  
        }

		if (depth == L) {
			System.out.println(sb);
			return;
		}

		for (int i = start; i < C; i++) {
			char 알파벳 = 가능한알파벳들[i];
			sb.append(알파벳);
			dfs(i + 1, depth + 1, 모음개수계산(모음카운트, 알파벳));
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static int 모음개수계산(int 모음카운트, char 알파벳) {
		return 모음카운트 + (모음.contains(알파벳) ? 1 : 0);
	}
    
    private static boolean isPromising(int depth, int 모음카운트) {
        int 남은칸 = L - depth;
        int 최소필요모음 = Math.max(0, 1 - 모음카운트);
        int 최소필요자음 = Math.max(0, 2 - (depth - 모음카운트));
    
        return 남은칸 >= (최소필요모음 + 최소필요자음);
    }

}
