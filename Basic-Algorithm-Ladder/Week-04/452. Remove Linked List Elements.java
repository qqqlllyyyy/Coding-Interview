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
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
        
    }
}

/*
    别把 else 的情况忘了 (head = head.next;).
*/
/*  2017-08-04
    判别条件是 head.next!=null, 不用担心最后一个元素是不是val, 
    因为在走到倒数第二个元素的时候，最后一个元素就已经被检查过了
*/
