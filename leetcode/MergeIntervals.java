import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Merge Intervals Given a collection of intervals, merge all overlapping
 * intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * http://discuss.leetcode.com/questions/233/merge-intervals
 */

/*
 * Sort and merge. Also we can using the insert algorithm which we have done before.
 */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Comparator<Interval> comparator = new Comparator<Interval>() {
			public int compare(Interval i, Interval j) {
				if (i.start < j.start) {
					return -1;
				} else if (i.start > j.start) {
					return 1;
				} else {
					if (i.end < j.end) {
						return -1;
					} else if (i.end > j.end) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		};
		Collections.sort(intervals, comparator);
		ArrayList<Interval> ret = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (ret.isEmpty()) {
				ret.add(cur);
			} else {
				Interval last = ret.get(ret.size() - 1);
				if (last.end >= cur.start) {
					last.end = Math.max(last.end, cur.end);
				} else {
					ret.add(cur);
				}
			}
		}
		return ret;
	}
}
