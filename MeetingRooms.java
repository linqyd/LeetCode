import java.util.Arrays;
import java.util.Comparator;

public class Leetcode {
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
	}
}

/**
 * Definition for an interval.
*/
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
    	Arrays.sort(intervals, new IntervalComparator());
    	for (int i = 0; i < intervals.length - 1; i++) 
			if(intervals[i+1].start < intervals[i].end)
				return false;
    	
    	return true;
    }
}

class IntervalComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		if(o1.start < o2.start)	return -1;
		else if(o1.start == o2.start)	return 0;
		
		return 1;
	}
}