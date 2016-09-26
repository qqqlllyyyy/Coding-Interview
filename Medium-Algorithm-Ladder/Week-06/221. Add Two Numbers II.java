/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        return reverse(addList1(l1, l2));
    }  
    
    // Reverse
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    // 和 167 题 'Add Two Numbers' 完全一样。
    private ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        
        return dummy.next;
    }
}

/*  20160921
	下面这种方法在逻辑上是对的，但是不能处理越界的情况，如果 v1 或 v2 大于 Integer.MAX_VALUE 就跪了。
	所以还是得用 167 题，把本题的正向变成反向来做.
*/

public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        
        int v1 = 0;
        int v2 = 0;
        
        while (l1 != null) {
            v1 = v1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            v2 = v2 * 10 + l2.val;
            l2 = l2.next;
        }
        
        // Get reversed result
        int sum = v1 + v2;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        do {
            head.next = new ListNode(sum % 10);
            sum /= 10;
            head = head.next;
        } while (sum != 0);
        // 这里不用后面的code是因为 0->null 和 0->null 要输出 0->null 而非 null;   
        // while (sum != 0) {
        //     head.next = new ListNode(sum % 10);
        //     sum /= 10;
        //     head = head.next;
        // }
        
        return reverse(dummy.next);
    }  
    
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
}
