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
     * @param nums an integer array list
     * @return the first node of linked list
     */
    public ListNode toLinkedList(ArrayList<Integer> nums) {  
        // Write your code here
        if (nums.size() == 0){
            return null;
        }
        ListNode head = null;
        ListNode temp = null;
        
        for (Integer num : nums){
            if (head == null) {
                head = new ListNode(num);
                temp = head;
            } else {
                temp.next = new ListNode(num);
                temp = temp.next;
            }
        }
        return head;
    }
}

/*  2016-08-05
    本题不必非判断head==null, 可以用dummy variable直接做, 我的解法:
*/
public class Solution {
    public ListNode toLinkedList(ArrayList<Integer> nums) {
        if (nums.size() == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}


/*
    head 单独占一个变量，不移动，因为最后要返回 head.
*/
