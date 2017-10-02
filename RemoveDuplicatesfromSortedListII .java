/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow, fast;
        ListNode start = new ListNode(0);
        start.next = head;
        slow = start;
        fast = head;
        while(fast != null)
        {
            while(fast.next!=null&&fast.val==fast.next.val)
                fast = fast.next;
            
            // the case two number are diff.
            if(slow.next==fast)
                slow = slow.next;
            // the case fase skip several nodes
            else
                slow.next = fast.next;
            
            fast = fast.next;
        }
        return start.next;
    }
}