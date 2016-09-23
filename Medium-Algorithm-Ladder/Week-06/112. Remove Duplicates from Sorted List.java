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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // head = dummy 
        
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }  
}

/*  20160913
    不要自作聪明加上第24行，先想想有无必要.
    如果加上第24行，那么当 head.val = 0 的时候结果会出错，因为第一个真正的节点会被跳过。
    比如 0->1->2->null 作为输入，输出的结果会变成 1->2->null
*/
