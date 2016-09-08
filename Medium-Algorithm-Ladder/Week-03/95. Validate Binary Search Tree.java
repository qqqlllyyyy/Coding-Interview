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
    boolean isBST;
    int min, max;
    public ResultType(boolean isBST, int min, int max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isBST;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE); // 注意MAX和MIN的设置
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if (left.isBST == false || right.isBST == false) {
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.max >= root.val ||
            root.right != null && right.min <= root.val) { // 这里不要忘了验证不为null
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true,
                            Math.min(root.val, left.min),
                            Math.max(root.val, right.max));
    }
}

/*
    注意 root==null 的时候大小值得设置，为了以后不断调低 min，要把起始 min 设置成最大值！
    因此要注意最后的 return，不能直接 min = left.min, 因为可能left==null, left.min = Integer.MAX_VALUE,
    所以要和 root.val 取个最小。
*/
