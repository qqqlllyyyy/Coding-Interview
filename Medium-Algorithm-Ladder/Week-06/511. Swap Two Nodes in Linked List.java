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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || v1 == v2) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode pre1 = null;
        ListNode pre2 = null;
        while (head.next != null) {
            if (head.next.val == v1) {
                pre1 = head;
            }
            if (head.next.val == v2) {
                pre2 = head;
            }
            head = head.next;
        }
        // Check not null
        if (pre1 == null || pre2 == null) {
            return dummy.next;
        }
        
        if (pre1.next == pre2) {
            ListNode temp = pre2.next.next;
            pre1.next = pre2.next;
            pre2.next.next = pre2;
            pre2.next = temp;
        } else if (pre2.next == pre1) {
            ListNode temp = pre1.next.next;
            pre2.next = pre1.next;
            pre1.next.next = pre1;
            pre1.next = temp;
        } else {
            ListNode node1 = pre1.next;
            ListNode node2 = pre2.next;
            ListNode post1 = pre1.next.next;
            ListNode post2 = pre2.next.next;
            
            pre1.next = node2;
            node2.next = post1;
            pre2.next = node1;
            node1.next = post2;
        }
        
        return dummy.next;
    }
}

/*  20160921
    第二次做这个题目，思路清晰多了，不要像答案一样为求简洁。我用比较稳的方法，讨论三种情况：
    pre1.next = pre2, pre2.next = pre1 以及两目标节点不相邻的情况。
*/
