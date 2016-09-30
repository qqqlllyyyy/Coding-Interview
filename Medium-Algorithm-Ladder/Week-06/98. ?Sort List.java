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
     *              using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMedian(head);
        ListNode leftDummy = new ListNode(0);
        ListNode middleDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode middleTail = middleDummy;
        ListNode rightTail = rightDummy;
        
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head; //
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head; 
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);// Not 'leftDummy.next', should be 'left'
    }
    
    
    private ListNode findMedian(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        node.next = left;
        node = getTail(node); // Why can not be 'node = getTail(left);' ?
        node.next = middle;
        node = getTail(node);
        node.next = right;
        return dummy.next;
    }
    
    
    private ListNode getTail(ListNode node) {
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
    
}

/*  20160915
    虽然code不短，但总的来说还是比较 straightforward，快速排序加分治法。
    每次找到中间节点，把链表分成三个小链表，比 mid 值小的，大的，相等的。
    最后再加在一起。
    ? 74行为什么不能把第二个 node 换成 left?
*/
