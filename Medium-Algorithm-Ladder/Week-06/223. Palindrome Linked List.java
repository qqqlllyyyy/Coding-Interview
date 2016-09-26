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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode head2 = reverse(middleNext);
        
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    
    // Reverse
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    
    // Find middle
    private ListNode findMiddle(ListNode head) {
        // Return nth number for 2n, (n+1)th for 2n+1
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/*  20160921
    第二次做这个题思路清晰了很多，先找到中间节点 middle, 把从 middle+1 开始的后半部分翻转。
    再和前半部分一一比较。
    值得注意的是如果原链表有奇数个节点，那么前半部分比后半部分多一个节点 (middle)
*/
