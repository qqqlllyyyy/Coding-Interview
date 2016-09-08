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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        int length = inorder.length;
        TreeNode root = new TreeNode(postorder[length - 1]);
        int position = findPosition(inorder, postorder[length - 1]);
        root.left = buildTree(subList(inorder, 0, position), subList(postorder, 0, position));
        root.right = buildTree(subList(inorder, position + 1, length), subList(postorder, position, length - 1));
        return root;
    }
    
    private int findPosition(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    private int[] subList(int[] list, int start, int end) {
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = list[i];
        }
        return result;
    }
}

/*
    和第73题很类似。
*/
