/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/***********************
 * 我的方法 2016-07-19
 * 先通过 'getReversedList' 获得一个全新的 List, 再和原来的一一比较
 * 但这个方法需要额外的space，并不如标准答案好.
 ***********************/

public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null) return true;
        
        ListNode last = getReversedList(head);
        ListNode first = head;
        while (first != null && last != null && first.val == last.val){ // 注意这里不是 'first.next != null'
            first = first.next;
            last = last.next;
        }
        return last == null;
    }
    
    private ListNode getReversedList(ListNode head) {
       ListNode prev_new = null;
       while (head != null) {
           ListNode temp = head.next;
           ListNode head_new = new ListNode(head.val);
           head_new.next = prev_new;
           prev_new = head_new;
           head = head.next;
       }
       return prev_new;
    }
}


/***********************
 * 标准解答
 ***********************/

public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
     
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next); // 这里要小心，括号里是把middle(不含)后面的部分反转
        
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
        // 注意不能返回 p1==null, 因为如果总共有奇数个节点，
        // 那么p2走到终点的时候，p1会走到中间值，并不是null.
    } 
     

    // 双指针返回中间的节点，若为偶数则返回中间较小的那个，即 n/2
    private ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
     
    // 把链表反转，并返回反转后的第一个节点 
    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

/*
  答案的方法比较好，只把链表的后半部分反转，然后一一比较，这样不需要额外空间。
*/
