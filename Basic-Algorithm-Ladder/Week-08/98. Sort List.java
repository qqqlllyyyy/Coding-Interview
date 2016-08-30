// version 1: Merge Sort
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
     * @return: You should return the head of the sorted linked list,
     *          using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) return head;
        
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null; // 别忘了这一步。切断左半边和右半边的联系。
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next; // 最后别忘了更新tail
        }
        
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }
        
        return dummy.next;
    }
}


/*************************************************************************/
// version 2: Quick Sort
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
     * @return: You should return the head of the sorted linked list,
     *          using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) return head;
        
        ListNode mid = findMedian(head); // O(n)
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        
        // 按照节点的value分成三个不同的链表
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = rightTail.next;
            } else {
                middleTail.next = head;
                middleTail = middleTail.next;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
        
    }
    
    
    // Find the median node in the linked list.
    private ListNode findMedian(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    // Finde the tail node of the linked list.
    private ListNode getTail(ListNode head) {
        if (head == null) return null;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    // Concatenate three linked lists
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = left;
        tail = getTail(tail);
        tail.next = middle;
        tail = getTail(tail);
        tail.next = right;
        tail = getTail(tail); // 这一行是不是可以去掉
        return dummy.next;
    }
    
    
}




/*
    两种方法都要掌握，本质上都是分治法。
*/
