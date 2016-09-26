/**
 * Definition for ListNode
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if (head == null) {
            return null;
        }
        HashSet<Integer> hash = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (hash.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                hash.add(head.next.val);
                head = head.next;
            }
        }
        
        return dummy.next;
    }  
}

/*  20160916
    注意 HashMap 的使用，整体思路和 452 题类似。
*/
