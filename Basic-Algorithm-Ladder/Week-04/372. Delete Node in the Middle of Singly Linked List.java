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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) return;
        
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}

/*
    注意，要移除链表中某个节点的时候不一定非要找到它之前的节点，可以直接让它的 val 和 next 相等，就指向了 Heap 中的同一个位置。
    再把 next 移除掉就可以了。
*/
