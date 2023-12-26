import static java.lang.Integer.*;
import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int houseCounts = parseInt(stringTokenizer.nextToken());
		int routerCounts = parseInt(stringTokenizer.nextToken());

		int[] houses = new int[houseCounts];
		for (int i = 0; i < houseCounts; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			houses[i] = parseInt(stringTokenizer.nextToken());
		}

		sort(houses);    // nlogn

		int l = 1; // 최소 거리
		int r = houses[houseCounts - 1] - houses[0]; // 최대 거리
		int answer = 0;

		while (l <= r) {
			int m = (l + r) / 2; // 중간 거리
			if (canPlaceRouter(houses, routerCounts, m)) {
				answer = m;
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		System.out.println(answer);
	}


	private static boolean canPlaceRouter(int[] houses, int routerCounts, int distance) {
		int count = 1;
		int lastInstall = houses[0];

		for (int house : houses) {
			if (house - lastInstall >= distance) {
				count++;
				lastInstall = house;
			}
		}
		return count >= routerCounts;
	}

}
