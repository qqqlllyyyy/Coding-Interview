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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int value = head.next.val;
                while (head.next != null && head.next.val == value) { // Don't forget 'head.next!=null'
                    head.next = head.next.next;
                }
            }
            else { // Don't forget this 'else'
                head = head.next;
            }
        }
        return dummy.next;
    }
}

/*  20160913
    注意第 27 行两个条件的顺序，
    以及 30 行不要忘记条件 'head.next!=null'
    第 34 行必须有这个 else，不能直接写上 head = head.next;
    因为在移除了 head 之后的下一个重复点列后，head不能贸然移动，比如： 1->2->2->3->3->null
    移除完 '2' 之后不能把 head 从1移动到3，因为所有的3最终都是要移除的。
*/
