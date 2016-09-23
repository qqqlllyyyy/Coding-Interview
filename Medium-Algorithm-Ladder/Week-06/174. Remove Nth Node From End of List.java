/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode fast, slow;
        
        dummy.next = head;
        head = dummy;
        fast = dummy;
        slow = dummy;
        
        for (int i = 0; i < n; i++){
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/*  20160913
    链表常见做法，dummy node 加双指针.
*/
