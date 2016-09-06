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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}

/*
    与 ‘Binary Tree Maximum Path Sum’ 不同，本题就是简单的递归。
    注意最后 return 的时候要比较 max(left, right) 与 0 的大小，可以为负。
*/
