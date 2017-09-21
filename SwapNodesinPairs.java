/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre, current;
        pre = start;
        current = head;
        
        while(current!=null)
        {
            if(current.next == null) break;
            ListNode temp = current.next;
            pre.next = temp;
            current.next = temp.next;
            temp.next = current;
            current = current.next;
            pre = pre.next.next;
        }
        
        return start.next; 
    }
}