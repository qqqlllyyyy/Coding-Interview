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
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // 每次head是一个新值，并且一定与后一个值不相等
        // (否则在执行head.prev操作的时候就把head和head.next都去掉了)
        // 因此，head如果走到了倒数第二个点，就可以终止了，因为最后一个点一定不同值.
        while (head.next != null && head.next.next != null) {
            
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
                // head = head.next; 注意不能有这一行，
                // 因为可能最后是 4->5->5->null, 去掉所有的‘5’之后是4->null
                // 令head=null的话，最外层的while循环'head.next'无意义。
                
                // 而且如果是 1->2->2->3->3->....这种情况，去掉所有的‘2’之后
                // 不能令 head=3, 那样的话head与head.next的值相等
                // 不符合最初的假设。
            } else {
                head = head.next;    
            }
        }
        return dummy.next;
    }
}
