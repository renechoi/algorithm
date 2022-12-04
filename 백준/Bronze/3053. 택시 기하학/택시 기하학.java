import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		double R = Double.parseDouble(bufferedReader.readLine());

		System.out.println(Math.PI * R * R);    // 파이R제곱 = 유클리드 거리
		System.out.println(2 * R * R);            // 2R제곱 = 맨하탄 거리
	}
}