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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || m >= n) {
            return head; // 注意不是return null; 可能 m == n 
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) { // 走 m-1 步  
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postnNode = head.next.next;
        
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        
        premNode.next = nNode;
        mNode.next = postnNode;
        
        return dummy.next;
        
    }
}

/*  20160915
    需要四个点, premNode, mNode, nNode, postnNode 来做最后的反转。
    注意监测边界条件的时候要 return head, 而不是 null, 因为如果 m == n 是有意义的，相当于反转后原链表不变
    27 行是走 m-1 步到 mNode 前面一个点.
*/
