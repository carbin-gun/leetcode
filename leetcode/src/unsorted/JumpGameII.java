package unsorted;
/**
 * Jump Game II
 * Greedy algorithm can pass, but the DP can not pass. 
 *
 */

public class JumpGameII {
	public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int jumps = 0;
        int currentMax = 0;
        int i = 0;
        if (A.length <= 1)
        		return 0;
        while (i < A.length) {
        	currentMax = i + A[i];
        	if (A[i] > 0) {
        		jumps++;
        	} else {
        		return 0;
        	}
        	if (currentMax >= A.length - 1)
        		return jumps;
        	int tmpMax = 0;
        	for (int j = i + 1; j <= currentMax; j++) {
        		if (j + A[j] >= tmpMax) {
        			tmpMax = j + A[j];
        			i = j;
        		}
        	}
        }
        return jumps;
    }
	
	public int jump_dp(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 1) {
            return 0;
        }
        int[] step = new int[A.length];
        step[0] = 0;
        for (int i = 1; i < A.length; i++) {
        	step[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < A.length; i++) {
            if (step[i] != Integer.MAX_VALUE) {
                if (i + A[i] <= A.length - 1) {
                    for (int j = i + 1; j <= i + A[i]; j++) {
                    	step[j] = Math.min(step[j], step[i] + 1);
                    }
                } else {
                	step[A.length - 1] = Math.min(step[A.length - 1], step[i] + 1);
                }
            }
        }
        return step[A.length - 1];
    }
	
	public static void main(String argv[]) {
		JumpGameII jp = new JumpGameII();
		int a[] = {1,2};
		jp.jump_dp(a);
	}
}
