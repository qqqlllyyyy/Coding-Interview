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
     * @param level the depth of the target level
     * @return an integer
     */
     
    private int sum = 0; // 这个 sum 在levelSum这个函数里定义的话就要传到helper中
    public int levelSum(TreeNode root, int level) {
        // Write your code
        helper(root, 1, level);
        return sum;
    }
    
    private void helper(TreeNode root, int depth, int level) {
        if (root == null) return;
        if (depth == level) sum += root.val;
        helper(root.left, depth + 1, level);
        helper(root.right, depth + 1, level);
        return; // 有没有这一行都可以通过
    }
}
