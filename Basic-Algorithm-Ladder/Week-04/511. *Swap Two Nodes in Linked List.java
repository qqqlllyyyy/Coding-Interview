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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        
        // int lastVisit = 0;
        // while (cur.next != null) {
        //     if (cur.next.val == v1) {
        //         node1Prev = cur;
        //         lastVisit = 1;
        //     }
        //     if (cur.next.val == v2) {
        //         node2Prev = cur;
        //         lastVisit = 2;
        //     }
        //     cur = cur.next;
        // }
        // if (node1Prev == null || node2Prev == null) return head;
        // if (lastVisit == 2) {
        //     ListNode temp = node2Prev;
        //     node2Prev = node1Prev;
        //     node1Prev = temp;
        // }
        
        
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            }
            if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }
        if (node1Prev == null || node2Prev == null) return head;
        if (node2Prev.next == node1Prev) {
            // make sure node1Prev is before node2Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }
        
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next; // 这里不能像Python一样把两个赋值写在一起
        ListNode node2Next = node2.next;
        if (node1.next == node2) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;
            node2Prev.next = node1;
            node1.next = node2Next;
        }
        return head;
    }
}

/*
    ? 第44-59行，为什么只需要判断 (node2Prev.next == node1Prev)? 有可能 node1Prev 在 node2Prev 后面但不紧跟着。
    另外，这一部分替换成我写的24-41行为什么不行?
*/

/*  2016-08-15
    只需要判断(node2Prev.next == node1Prev)是因为，就算node2在前，只要它和node1之间隔着几个点，那么第68-73行就可以覆盖这种情况了。
*/
