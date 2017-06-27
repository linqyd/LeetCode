import java.util.HashMap;
import java.util.Map;

public class Leetcode {
	public static void main(String[] args) {
		// test case
		Logger obj = new Logger();
		boolean param_0 = obj.shouldPrintMessage(1,"foo");
		System.out.println(param_0);
		boolean param_1 = obj.shouldPrintMessage(3,"foo");
		System.out.println(param_1);
		boolean param_2 = obj.shouldPrintMessage(10,"foo");
		System.out.println(param_2);
		boolean param_3 = obj.shouldPrintMessage(11,"foo");
		System.out.println(param_3);
		
	}
}

class Logger {
	Map<String, Integer> msg; 
    /** Initialize your data structure here. */
    public Logger() {
        msg = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	if(!this.msg.containsKey(message)){
    		this.msg.put(message, timestamp);
    		return true;
    	}
    	else if(timestamp - this.msg.get(message) >= 10) {
    		this.msg.replace(message, timestamp);
    		return true;
    	}
    	else 
    		return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */