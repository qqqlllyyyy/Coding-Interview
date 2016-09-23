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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        // Get Size
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        
        current = head;
        return sortedListToBSTHelper(size);
    }
    
    
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
}

/*  20160914
    sortedListToBSTHelper 会在48行一直往左走，走到最左之后运行第28行，这个时候 ‘current’ 应该是值最小的点。
    多体会 50 行的重要性，因为一开始 current 在 head 的位置，也就是最小点。
    需要把这个指针慢慢往右移动。
*/
