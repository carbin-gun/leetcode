package unsorted;

/**
 * Container With Most Water
 */
public class Container {
	public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height.length < 2) {
            return 0;
        } 
        int shortLine = 0;
        int maxArea = 0;
        int f = 0;
        int r = height.length - 1;
        while (f < r) {
            if (height[f] > height[r]) {
                shortLine = height[r];
                int tmp = (r - f) * shortLine;
                maxArea = maxArea > tmp ? maxArea : tmp;
                r--;
            } else {
                shortLine = height[f];
                int tmp = (r - f) * shortLine;
                maxArea = maxArea > tmp ? maxArea : tmp;
                f++;
            }
        }
        return maxArea;               
    }
	
	public static void main(String argv[]) {
		int input[] = {1, 1};
		System.out.println(new Container().maxArea(input));
	}
}
