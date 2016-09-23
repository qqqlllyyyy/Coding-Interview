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
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;
        
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            // Insert head between node and node.next
            head.next = node.next;
            node.next = head;
            // Move head to the head.next.
            head = temp;
        }
        
        return dummy.next;
    }
}

/*  20160916
    掌握插入排序: http://bubkoo.com/2014/01/14/sort-algorithm/insertion-sort/
    1. 从第一个元素开始，该元素可以认为已经被排序
    2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
    3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
    4. 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
    5. 将新元素插入到该位置后
    6. 重复步骤 2~5
*/
