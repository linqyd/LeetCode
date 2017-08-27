package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		// 20->7->8
		ListNode lNode = new ListNode(20);
		lNode.next = new ListNode(7);
		lNode.next.next = new ListNode(21);
		lNode.next.next.next = new ListNode(1);
//		lNode.next.next.next.next = new ListNode(9);
//		lNode.next.next.next.next.next = new ListNode(11);
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

class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null) return head;
    	
    	List<Integer> result = new ArrayList<>();
    	result.add(head.val);
    	head = head.next;
    	boolean isInserted = false;
    	
    	while(head != null){
    		isInserted = false;
    		for (int i = 0; i < result.size(); i++) 
    			if(head.val <= result.get(i)) {
    				result.add(i, head.val);	
    				isInserted = true;
    				break;
    			}
    		// add to the tail	
    		if(!isInserted)
				result.add(head.val);
    		head = head.next;
    	}
    	ListNode newHead = new ListNode(result.get(0));
    	ListNode current = newHead;
    	
    	for (int i = 1; i < result.size(); i++) {
			current.next = new ListNode(result.get(i));
			current = current.next;
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