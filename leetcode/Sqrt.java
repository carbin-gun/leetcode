

/**
 * Sqrt(x) be careful of overflow!
 * still binary can not pass large data,
 * there is a good method of improve to binary search, it search from 2, every time
 * pow is by 2, and if larger then do binary search.
 */
public class Sqrt {
	public int sqrt(int x) {
		if (x == 0) {
			return 0;
		}

		int s = 2;
		int prev = 1;
		while (!(s <= x / s && (s + 1 > x / (s + 1)))) {
			if (s < x / s) {
				prev = s;
				s = s * s;
			} else {
				s = prev + (s - prev) / 2;
			}
		}
		return s;
	}
	
	
	public int sqrtNoLarge(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int ret = 0;
		int s = 0;
		int e = x;
		while (s <= e) {
			int mid = s + (e - s) / 2; // over flow;
			if (mid > 46340) {
				e = mid - 1;
			}
			if (mid * mid > x) {
				e = mid - 1;
			} else {
				ret = mid;
				s = mid + 1;
			}
		}
		return ret;
	}

	public int sqrt1(int x) {
		if (x == 0) {
			return 0;
		}

		int s = 2;
		int prev = 1;
		while (!(s <= x / s && (s + 1 > x / (s + 1)))) {
			if (s < x / s) {
				prev = s;
				s = s * s;
			} else {
				s = prev + (s - prev) / 2;
			}
		}
		return s;
	}

	public static void main(String argv[]) {
		Sqrt s = new Sqrt();
		for (int i = 0; i <= 100; i++) {
			System.out.println(i + "=" + s.sqrt(i));
		}
	}
}
