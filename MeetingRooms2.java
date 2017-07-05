import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		Interval[] intervals = {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
		Solution solution = new Solution();
		System.out.println(solution.minMeetingRooms(intervals));
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
    public int minMeetingRooms(Interval[] intervals) {
    	Arrays.sort(intervals, new IntervalComparator());
    	List<Integer> starting = new ArrayList<>();
    	
    	for (int i = 0; i < intervals.length; i++) {
			if(starting.isEmpty())
				starting.add(intervals[i].end);
			else {
				boolean isSet = false;
				for (int j = 0; j < starting.size(); j++) {
					if(intervals[i].start >= starting.get(j)) {
						starting.set(j,intervals[i].end);
						isSet = true;
						break;
					}	
				}
				if(!isSet)
					starting.add(intervals[i].end);
			}
		}
    	return starting.size();
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