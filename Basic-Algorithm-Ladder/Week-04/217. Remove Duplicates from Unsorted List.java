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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        HashSet<Integer> hash = new HashSet<Integer>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (hash.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                hash.add(head.next.val);
                head = head.next;
            }
        }
        return dummy.next;
        
    }  
}

/*
    Class HashSet: 1. contains(); 2. add();
    ----------------------------------------------------
    HashSet 和 HashMap 的区别:
    They are entirely different constructs. A HashMap is an implementation of Map. A Map maps keys to values. The key look up occurs using the hash.
    On the other hand, a HashSet is an implementation of Set. A Set is designed to match the mathematical model of a set. A HashSet does use a HashMap to back its implementation, as you noted. However, it implements an entirely different interface.
*/
