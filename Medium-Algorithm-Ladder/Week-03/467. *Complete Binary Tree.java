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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        
        if (root == null) {
            return true;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int index = 0;
        while (index < list.size()) {
            if (list.get(index) != null) {
                TreeNode node = list.get(index);
                list.add(node.left);
                list.add(node.right);
            }
            index++;
        }
        
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                return false;
            }
        }
        return true;
    }
}

/*
    满二叉树：每个节点都有0或是2个孩子
    完全二叉树：所有的叶子都拥有同的深度，所有的内部节点拥有 2个孩子
    中文解答：http://www.jianshu.com/p/95d36779d754
    但我的这个方法和解答不太一样，不是用的stack，因为无法直接取到stack的第i个元素，所以用的ArrayList
    --------------------------------------------------------------------------------
    九章的分治法如下：注意理解这两种情况，以及 isFull 和 isComplete
*/

class ResultType {
    public int depth;
    public boolean isFull, isComplete;
    ResultType(int depth, boolean isFull, boolean isComplete) {
        this.depth = depth;
        this.isFull = isFull;
        this.isComplete = isComplete;
    }
}

public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        ResultType result = helper(root);
        return result.isComplete;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true, true);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isComplete) {
            return new ResultType(-1, false, false);
        }
        
        // depth is the same, left should be full and right should be complete
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, right.isFull, true);
        }
        
        // left.depth = right.depth + 1, left should be complete and right should be full
        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, false, true);
        }
        
        return new ResultType(-1, false, false);
    }
}
