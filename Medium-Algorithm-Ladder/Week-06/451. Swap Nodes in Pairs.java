/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            
            // From: head -> n1 -> n2 -> ...
            // To: head -> n2 -> n1 -> ...
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            
            head.next = n2;
            ListNode temp = n2.next;
            n2.next = n1;
            n1.next = temp;
            head = n1;
        }
        return dummy.next;
    }
}

/*  20160916
    简单题
*/
