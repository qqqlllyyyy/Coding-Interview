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
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (root == null) return result;
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void helper(TreeNode root,
                        String path,
                        List<String> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(path); // 注意这里的pass是包含了root的value的，不需要额外的添加。
        }
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}

/*
    这里特别注意！第33&36行的double quote不能改成single quote;
    Java中，char 型变量只能用 single quote, 而 String 型变量只能用 double quote.
    详见: http://stackoverflow.com/questions/439485/is-there-a-difference-between-single-and-double-quotes-in-java
*/
