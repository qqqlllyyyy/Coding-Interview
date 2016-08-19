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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }
    
    private void helper(TreeNode root, 
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {
        
        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            } 
            return; // 这里改成 'else{return;}' 也可以通过。
        }
        // go left
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            path.remove(path.size() - 1); // 别忘了最后拿掉这一步加上的最后一个点root.left
        }
        // go right
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}


/*
    有关树的第一道题，用到DFS。
    注意第38行，initialize一个新的List的时候可以直接把list扔进 'new ArrayList<Integer>()' 的括号里。
*/ 
