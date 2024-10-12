import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int 사람수 = Integer.parseInt(br.readLine());

		System.out.println(당첨자구하기(사람수));

	}
    
    private static int 당첨자구하기(int 사람수) {
		int 당첨자 = 0; // 초기 당첨자 위치 (0 기반 인덱싱)
		for (int n = 2; n <= 사람수; n++) {
			int t = 사람수 - n + 1; // 단계 번호를 1부터 사람수-1까지 증가
			long 단계별횟수 = (long) t * t * t; 
			당첨자 = (int) ((당첨자 + 단계별횟수) % n); 
		}
		return 당첨자 + 1; // 1부터 시작하는 인덱스로 변환하여 반환
	}
}
