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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return helper(lists, 0, lists.size() - 1);
    }
    
    private ListNode helper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                pre = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                pre = node2;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            pre.next = node1;
        }
        if (node2 != null) {
            pre.next = node2;
        }
        return dummy.next;
    }
}

/*
    这个两两比较的方法比较笨，学完第八课heap之后回来看答案里用heap的解法。
*/
