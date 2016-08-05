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
     * @param head: The head of linked list.
     * @param val: an integer
     * @return: The head of new linked list
     */
    public ListNode insertNode(ListNode head, int val) { 
        // Write your code here
        ListNode dummy = new ListNode(0);
        ListNode target = new ListNode(val);
        
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        
        target.next = head.next;
        head.next = target;
        
        return dummy.next;
    }  
}

/*
    链表的题目不要忘记 dummy node 的使用。
    注意 while 的循环条件，这里如果所有的 node value 都小于 'val' 的话，head 就会走到最后一个节点，head.next 为 null. 照样可以取下 head 的指针指向 target, 并将 target 的指针指向 null.

    注意最后的返回值应该是首节点，即 'dummy.next'.
*/
