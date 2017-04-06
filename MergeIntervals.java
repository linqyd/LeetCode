import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		List<Interval> list = new ArrayList();
		list.add(new Interval(5,10));
		list.add(new Interval(2,4));
		list.add(new Interval(6,8));
		list.add(new Interval(9,17));
		list.add(new Interval(20,25));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).start + " " + list.get(i).end);
		}
		
		Solution solution = new Solution();
		ArrayList<Interval> result =(ArrayList<Interval>) solution.merge(list);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).start + " " + result.get(i).end);
		}
	}
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// author: Sylvia
// Time: O(n lon n), Space: O(n) or O(1)?
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	// sort the list by start element
		intervals.sort(new IntervalComparator());
    	for(int i = 0; i < intervals.size() - 1; i++){
    		// check the pre upper bound with the next lower bound
    		if(intervals.get(i).end >= intervals.get(i+1).start) {
    			intervals.get(i+1).start = intervals.get(i).start;
    			intervals.get(i+1).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
    			intervals.remove(i);
    			i--;
    		}
    	}
    	return intervals;
    }
}

class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1, Interval o2) {
		if(o1.start > o2.start)
			return 1;
		else if (o1.start < o2.start)
			return -1;
		else
			return 0;
	}	
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}