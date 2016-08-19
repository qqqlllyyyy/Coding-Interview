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
     * @param root the root of the binary tree
     * @return an integer
     */
     
    private int sum = 0;
    public int leafSum(TreeNode root) {
        // Write your code 
        helper(root);
        return sum;
    }
    private void helper(TreeNode root) {
        if (root == null) return; // 必须要检查，否则会出错。
        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        helper(root.left);
        helper(root.right);
    }
}
