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
    int depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        this.helper(root, 1);
        return depth;
    }
    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            depth = Math.min(depth, currentDepth);
        }
        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}

/*
    每次遇到左右子节点都为null的leaf才比较当前深度和最后要返回的最小深度。
*/

/*  20160909
    想要不使用 global variable.
    为什么如下解法行不通，最终没有改变 depth 的结果，输出一直是 2147483647 ?
*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int depth = Integer.MAX_VALUE;
        helper(root, 1, depth);
        return depth;
    }
    private void helper(TreeNode root, int currentDepth, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            depth = Math.min(depth, currentDepth);
        }
        helper(root.left, currentDepth + 1, depth);
        helper(root.right, currentDepth + 1, depth);
    }
}
