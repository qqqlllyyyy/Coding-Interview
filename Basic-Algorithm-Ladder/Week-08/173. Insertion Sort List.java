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
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        
        return dummy.next;
    }
}


/*
    对 head 进行循环，每取定一个head之后，就从dummy开始依次找已经加在dummy后面的所有点，找到第一个比head的值大的点(node.next)的前面的点
    然后把head插入node与node.next之间。然后让 head 往后走一位。
    其实就是维护第二个从dummy开始的链表，对于每一个新元素(head)，都看看能把head插入第二条链表的什么位置，以保证第二条链表的单调性
    ------------------------------------------------------------------------------------------------------------
    第一步的时候，node就是dummy，即把head接在dummy的后面。再把head在原链表中往后移 (head = temp)
*/
