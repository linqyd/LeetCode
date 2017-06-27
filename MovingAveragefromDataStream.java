import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		// don't have to deal with the case size = 0
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
		
	}
}

class MovingAverage {
	List<Integer> ele;
	int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        ele = new ArrayList<>();
        this.size = size;
    }
    
    public double next(int val) {
    	double sum = 0;
        ele.add(val);
        
        if(ele.size() < this.size){
        	for (int i = 0; i < ele.size(); i++) sum += ele.get(i);
        	return sum/ele.size();
        }
    	else {
			for (int i = ele.size()-this.size; i < ele.size(); i++)	sum += ele.get(i);
			return sum/this.size;
		}
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */