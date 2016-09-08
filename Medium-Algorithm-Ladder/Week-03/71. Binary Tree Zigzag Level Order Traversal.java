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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp = new Stack<TreeNode>();
        currentLevel.push(root);
        int row_index = 0;
        while (!currentLevel.isEmpty()) {
            int currentLength = currentLevel.size();
            ArrayList<Integer> result_row = new ArrayList<Integer>();
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = currentLevel.pop();
                result_row.add(node.val);
                if (row_index % 2 == 0) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                }
            }
            result.add(result_row);
            temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            row_index++;
        }
        return result;
    }
}

/*
    和第69题有点类似，但这里不是用一个 queue，而是两个stack来记录当前层和下一层。
    注意要有一个row_index来记录当前层数是偶数还是奇数，因为这会影响到是先往nextLevel中加入左节点还是右节点。
    另外几个注意事项之前遇到过，currentLevel必须在循环前就定好，因为在循环体内 currentLevel 的size会发生变化。
    其实第34行可以换成 while(!currentLevel.isEmpty()){ ...
*/
