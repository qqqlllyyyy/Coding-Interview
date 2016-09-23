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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}


/*  20160915
    这个题目一开始我想存每个点的 value 到一个 list 中再查重，可是这样是错的。因为 value 一样的节点不一定是同一节点。
    如果有cycle，那代表着永远走不出来，用双指针来做，
    一个走得慢，一个走得快，如果有loop，就一定会遇到。
    while 循环的条件是 slow != fast, 而不是 slow.val != fast.val
*/
