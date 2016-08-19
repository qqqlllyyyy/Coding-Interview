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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        helper(root, 1);
        return depth;
    }
    private void helper(TreeNode root, int curDepth) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (curDepth < depth) depth = curDepth;
        }
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}
