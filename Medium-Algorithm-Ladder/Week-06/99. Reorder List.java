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
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null; // Don't forget this.
        merge(head, tail);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode current = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }
        return current; // Because head is null in the end.
    }
    
    private void merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        int index = 0;
        while (node1 != null && node2 != null) {
            if (index % 2 == 0) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (node1 != null) {
            dummy.next = node1;
        } else {
            dummy.next = node2;
        }
    }
}

/*  20160915
    这个题的思路并不算太难，但是要确保写代码的过程中不出错。
    先把原链表分成前后两部分，把第二部分翻转，再merge到一起。
    注意别忘了要把前半部分的最后一个节点的 next 指向 null
*/
