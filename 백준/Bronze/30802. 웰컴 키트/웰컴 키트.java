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
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int 전체인원 = parseInt(st.nextToken());

		int 사이즈 = 6;
		int[] 티셔츠카운팅 = new int[사이즈];
		st = new StringTokenizer(br.readLine());
		for (int i =0;i<사이즈; i++){
			티셔츠카운팅[i] = parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int 티셔츠묶음 = parseInt(st.nextToken());
		int 펜묶음 = parseInt(st.nextToken());

		long 티셔츠최소묶음개수 = 0;
		for (int count : 티셔츠카운팅) {
			티셔츠최소묶음개수 += (count + 티셔츠묶음 - 1L) / 티셔츠묶음;
		}

		int 펜최소묶음개수 = 전체인원 / 펜묶음;
		int 펜개별 = 전체인원 % 펜묶음;

		System.out.println(티셔츠최소묶음개수);
		System.out.println(펜최소묶음개수 + " " + 펜개별);
	}

}
