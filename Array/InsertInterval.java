package Array;

import java.util.ArrayList;
/**
	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	
	You may assume that the intervals were initially sorted according to their start times.
	
	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
	
	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
	
	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
	
	public class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	
    	int p = 0;
    	while(p < intervals.size()) {
    		if(intervals.get(p).end < newInterval.start) {
    			result.add(intervals.get(p));
    			p++;
    		} else {
    			newInterval.start = Math.min(newInterval.start, intervals.get(p).start);
    			break;
    		}
    	}
    	
    	result.add(newInterval);
    	
    	while(p < intervals.size()) {
    		if(intervals.get(p).start > newInterval.end) {
    			result.add(intervals.get(p));
    		} else if(intervals.get(p).end >= newInterval.end && intervals.get(p).start <= newInterval.end) {
    			newInterval.end = Math.max(newInterval.end, intervals.get(p).end);
    		} 
    		p++;
    	}
    	
    	return result;
    }
}
