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
    // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
    // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
    int singlePath, maxPath;
    public ResultType(int singlePath, int maxPath) {
        this.singlePath = singlePath;
        this.maxPath = maxPath;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return helper(root).maxPath;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // Conquer
        // int singlePath = Math.max(0, root.val + left.singlePath, root.val + right.singlePath);
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath) + root.val); // 注意Math.max只能比较两个值
        
        int max = Math.max(left.maxPath, right.maxPath);
        int maxPath = Math.max(max, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }
    
}

/*
    注意Math.max只能比较两个值
    singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
    maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
    root == null 的时候要让 singlePath 为 0， 因为可以不包含点。
    *但 maxPath 应该是最小整数，因为题目要求至少包含一个点，点的值可能是负的。
*/
