/**
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, k1, k2, result);
        return result;
    }
    private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            helper(root.left, k1, k2, result); // k2不能换成root.val因为前者可能更小
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2, result);
        }
    }
}


/*
    其实和中序遍历很类似，是指每次把节点值加入result的时候要先检查是不是在k1和k2之间。
    也可以像标准答案一样吧result定义成为 global variable,
    这样的话helper函数可以只有前三个输入变量。
*?
