package unsorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/**
 * Merge Intervals If we sort the intervals first and then merge, it can not
 * pass the large data.
 */

public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		ArrayList<Interval> newList = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			newList = insert(newList, intervals.get(i));
		}
		return newList;
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval interval) {
		if (intervals.size() == 0) {
			intervals.add(interval);
			return intervals;
		}
		int s = -1;
		int e = -1;
		for (int i = 0; i < intervals.size(); i++) {
			if (s == -1 && intervals.get(i).end >= interval.start) {
				s = i;
			}
			if (intervals.get(i).start <= interval.end) {
				e = i;
			}
		}
		if (s == -1) {
			intervals.add(interval);
		} else if (e == -1) {
			intervals.add(0, interval);
		} else {
			interval.start = Math.min(interval.start, intervals.get(s).start);
			interval.end = Math.max(interval.end, intervals.get(e).end);
			intervals.subList(s, e + 1).clear();
			intervals.add(s, interval);
		}
		return intervals;
	}

	public ArrayList<Interval> mergeNoneLarge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start)
					return 1;
				else
					return 0;
			}
		});

		Iterator<Interval> iterator = intervals.iterator();
		Interval pre = iterator.next();
		while (iterator.hasNext()) {
			Interval cur = iterator.next();
			if (pre.end >= cur.start) {
				pre.end = Math.max(pre.end, cur.end);
				iterator.remove();
			} else {
				pre = cur;
			}
		}
		return intervals;
	}
}
