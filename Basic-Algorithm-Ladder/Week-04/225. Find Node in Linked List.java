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
     * @param head: the head of linked list.
     * @param val: an integer
     * @return: a linked node or null
     */
    public ListNode findNode(ListNode head, int val) { 
        // Write your code here
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }  
}


/*
    注意这种 for 循环的写法，可以直接用一个 for 语句遍历所有的链表节点 ListNode.   
*/
