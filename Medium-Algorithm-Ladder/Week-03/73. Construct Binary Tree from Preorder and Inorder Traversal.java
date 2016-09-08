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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    private int findPosition (int[] list, int target) {
        int result = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i;
            }
        }
        return result;
    }
    
    private int[] subList(int[] list, int start, int end) {
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = list[i];
        }
        return result;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        int m = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int position = this.findPosition(inorder, preorder[0]);
        root.left = buildTree(subList(preorder, 1, position + 1), subList(inorder, 0, position));
        root.right = buildTree(subList(preorder, position + 1, m), subList(inorder, position + 1, m));
        return root;
    }
}

/*
    由于 Python 中有直接从list中获得元素位置的 indexOf 命令，以及直接获取 sublist 的 [a:b] 命令，所以会很简单。
    而我的这个解法，就是把这两个 Python 内置命令写成小函数。
*/
