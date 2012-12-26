package unsorted;

import java.util.ArrayList;
/**
 * Insert Interval
 * This is a little bit skillful, every one know the question, but hard to write down
 * a smart solution.
 *
 */
public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int s = -1;
		int e = -1;

		for (int i = 0; i < intervals.size(); i++) {
			if (s == -1 && newInterval.start <= intervals.get(i).end) {
				s = i;
			}
			if (newInterval.end >= intervals.get(i).start) {
				e = i;
			}
		}

		if (s == -1) {
			intervals.add(newInterval);
		} else if (e == -1) {
			intervals.add(0, newInterval);
		} else {
			int start = Math.min(intervals.get(s).start, newInterval.start);
			int end = Math.max(intervals.get(e).end, newInterval.end);
			intervals.subList(s, e + 1).clear();
			if (s < intervals.size()) {
				intervals.add(s, new Interval(start, end));
			} else {
				intervals.add(new Interval(start, end));
			}
		}
		return intervals;
	}
}
