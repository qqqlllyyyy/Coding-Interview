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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) return node; // 注意是要返回node而不是null，插入后有唯一节点node
        
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        }
        
        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        }
        
        return root; // 最后要return最初节点的
    }
}

/*
    体会分治，递归到最后一定会出现某节点".left"或者".right"是空的情况，此时再递归一次就一定会执行第20行的命令。
*/
