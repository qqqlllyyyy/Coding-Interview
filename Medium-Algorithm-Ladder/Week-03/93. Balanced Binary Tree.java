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
 
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) { // 注意不能加 'void'
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return helper(root).isBalanced;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        
        if (leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.maxDepth - rightResult.maxDepth) <= 1) {
            return new ResultType(true, Math.max(leftResult.maxDepth, rightResult.maxDepth) + 1);
        }
        return new ResultType(false, -1);
    }
}

/*
    新建一个 ResultType 来传递多个不同类型的参数，要习惯这种用法。
    注意第16行的 constructor function 前面不能加'void', 否则会出错。
*/

