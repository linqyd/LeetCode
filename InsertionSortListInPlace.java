class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null) return null;
    	
    	boolean isInserted = false;
    	// current elem needs to be inserted, current elem in sorted list
    	ListNode currentInsEle, currentEle, insertPre, temp;
    	currentInsEle =  head.next;
    	insertPre = currentEle = head;
    	int count = 0;
    	// need keep track of head pointer
    	ListNode newHead = head;
    	
    	while(currentInsEle != null){
            isInserted = false;
    		count++;
    		currentEle = newHead;
    		// delete current inserted ele from the unsorted part
    		insertPre.next = currentInsEle.next;
    		// insert to head
    		if(currentInsEle.val < newHead.val)
    		{
    			currentInsEle.next = newHead;
    			newHead = currentInsEle;
    			currentInsEle = insertPre.next;
    			continue;
    		}
    		// insert to middle
    		for (int i = 0; i < count - 1; i++) {
				if(currentInsEle.val < currentEle.next.val){
					temp = currentEle.next;
					currentEle.next = currentInsEle;
					currentEle.next.next = temp;
					// set the pointer to next ele to be inserted
					currentInsEle = insertPre.next;
					isInserted = true;
					break;
				}
				currentEle = currentEle.next;
			}
    		if(!isInserted){
	    		// add ele to the tail of the list
	    		currentInsEle.next = currentEle.next;
	    		currentEle.next = currentInsEle;
	    		insertPre = currentInsEle;
	   			currentInsEle = insertPre.next;
    		}
    	}
    	return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Leetcode {
    public static void main(String[] args) {
        // 20->7->8
        ListNode lNode = new ListNode(20);
//      lNode.next = new ListNode(7);
//      lNode.next.next = new ListNode(21);
//      lNode.next.next.next = new ListNode(1);
//      lNode.next.next.next.next = new ListNode(9);
        Solution solution = new Solution();
        ListNode head = solution.insertionSortList(lNode);
        while(head != null)
        {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        if(head == null)
            System.out.print("Nil");
    }
}