/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = getLength(head);
        int rotateLength = k % length;
        if (rotateLength == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < rotateLength; i++) {
            fast = fast.next;
        }
        while (fast.next != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = dummy.next;
        
        return temp;
    }
    
    // Get length of the LinkedList
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
}

/*  20160921
    注意这里的 k 可能比整个链表的长度还要大，所以要先通过 getLength 来计算出整个链表的长度。取余数。
*/
