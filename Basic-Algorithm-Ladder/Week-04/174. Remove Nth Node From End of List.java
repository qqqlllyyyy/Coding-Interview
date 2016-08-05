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
        
        if (n <= 0) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy; 
        ListNode slow = dummy;
        ListNode temp = dummy; // 用来记录 slow 的前一个节点
        
        for (int i = 0; i < n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        
    
        while (fast != null) {
            temp = slow; // 这里也可以改成 if(slow!=dummy) temp = temp.next;
            slow = slow.next;
            fast = fast.next;
        }
        
        temp.next = slow.next;
        return dummy.next; // 注意这里不能是 head, 因为可能 head 被移除掉了.
        
    }
}


/*
    去掉第一行 'if(n <= 0)' 也可以通过检验.
*/
