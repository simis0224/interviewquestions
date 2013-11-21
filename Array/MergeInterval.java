package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
	Given a collection of intervals, merge all overlapping intervals.
	
	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 */
public class MergeInterval {
	
	public class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
		
	}
	
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	Collections.sort(intervals, new IntervalComparator());
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	
    	if(intervals.size() <= 1) {
    		return intervals;
    	}
    	
		result.add(intervals.get(0));
    	for(int i = 1 ; i < intervals.size(); i++) {
			Interval top = result.get(result.size() - 1);
			if(top.end >= intervals.get(i).start) {
				// pick the larger end
				top.end = Math.max(top.end, intervals.get(i).end);
			} else {
				result.add(intervals.get(i));
			}
    	}

        return result;
    }
    
}
