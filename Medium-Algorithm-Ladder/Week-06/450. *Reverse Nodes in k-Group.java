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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            head = helper(head, k);
        }
        
        return dummy.next;
    }
    
    // From: head -> n1 -> n2 -> ... -> nk -> ...
    // To: head -> nk -> ... -> n2 -> n1 -> ...
    // return n1
    private ListNode helper(ListNode head, int k) {
        
        // check there is enought nodes to reverse
        ListNode checkLength = head;
        for (int i = 0; i < k; i++) {
            if (checkLength.next == null) {
                return checkLength;
            }
            checkLength = checkLength.next;
        }
        
        // Similar as 'reverse linked list', but we need one more listnode 'n1' 
        // to remember where 'n1' is. It is the output node.
        ListNode n1 = head.next;
        
        ListNode current = n1;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        
        head.next = pre;
        n1.next = current;
        return n1;
    }
}

/*  20160921
    其实也没有特别难。题目要求每 k 个做翻转操作。那么就从 dummy 开始，每次把它后面的的k个进行翻转。
    循环终止条件是 helper 的输出值是最后一个节点。
    那么这个 helper 的输出函数就应该是这样的：
    如果长度足够，输出翻转后 k 个节点的最后一个，否则输出整个链表的最后一个节点
    再看一遍想一想，尤其是helper函数要再写一遍。第一次写晕了。
*/
