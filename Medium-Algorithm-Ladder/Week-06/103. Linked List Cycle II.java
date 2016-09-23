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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while (slow.next != head) { // Not 'slow != head'
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}

/*  20160916
    虽然本题感觉很难，但纯粹是个数学题，老师说可以跳过。
    详细解释见: http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
*/
