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
        if (m >= n || head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) { // 从 1 开始，找个例子比如m=2的时候，head只能从dummy前进一次。
            if (head == null) {
                return null; // 这里是否返回 dummy.next 都可以
            }
            head = head.next;
        }
        ListNode premNode = head;
        ListNode mNode = head.next, nNode = head.next, postnNode = head.next.next;
        
        for (int i = m; i < n; i++) {
            if (postnNode == null) return null;
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


/*
    本题是要把从第 m 个到第 n 个全都反转，注意细节，多写几遍。
*/
