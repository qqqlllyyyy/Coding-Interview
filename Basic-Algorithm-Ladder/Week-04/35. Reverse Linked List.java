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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


/* 
    最后要返回的是 prev 而不是 head. 因为 head 已经走到了最后成了 null.
*/

/*  2016-04-04
    初期必须定义一个prev是因为我们再循环过程中要一直让head往后走，所以不能让'head.next'指向head,
    所以只能在经过一个点之后再更改指针，也就是令 head.next = prev
*/
