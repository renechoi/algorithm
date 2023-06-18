package basic.math;

public class GcdAndLcm {
	public static void main(String[] args) {
		int a = 12;
		int b = 18;

		int gcd = getGcd(a, b);
		System.out.println("최대공약수: " + gcd);

		int lcm = getLcm(a, b);
		System.out.println("최소공배수: " + lcm);
	}

	public static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

	public static int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}
}
