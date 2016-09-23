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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int remain = 0;
        while (l1 != null && l2 != null) {
            int tempSum = remain + l1.val + l2.val;
            remain = tempSum / 10;
            head.next = new ListNode(tempSum % 10);
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while (l1 != null) {
            int tempSum = remain + l1.val;
            remain = tempSum / 10;
            head.next = new ListNode(tempSum % 10);
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            int tempSum = remain + l2.val;
            remain = tempSum / 10;
            head.next = new ListNode(tempSum % 10);
            l2 = l2.next;
            head = head.next;
        }
        
        // Don't forget this!!
        if (remain != 0) {
            head.next = new ListNode(remain);
        }
        
        return dummy.next;
        
    }
}

/*  20160921   
    看起来有点长，但是思路很简单，用一个 remain 来维护进位。
    一定不要忘了最后判断 remain 是否为0的条件，因为可能加到最后还剩一个进位的1.
*/
