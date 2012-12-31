package unsorted;

/**
 * Pow(x, n)
 * 
 */
public class Pow {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			return 1;
		}
		int m = Math.abs(n);
		double base = x;
		double result = 1;
		while (m >= 1) {
			if (m % 2 == 1) {
				result *= base;
			}
			m = m >> 1;
			base = base * base;
		}
		if (n < 0) {
			return 1/result;
		} else {
			return result;
		}
	}

	public static void main(String argv[]) {
		Pow p = new Pow();
		System.out.println(p.pow(2, 10));
	}
}
