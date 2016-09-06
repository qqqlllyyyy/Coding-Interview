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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 注意这里的第二个条件不能改成 i < queue.size() !!!
            // 因为执行循环的时候每次都会拿出或者添加元素进 queue
            // 所以每进行完一个 i 的操作后 queue.size() 可能会变化。
                TreeNode node = queue.poll();
                row.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(row);
        }
        return result;
    }
}

/*
    注意queue的用法，Queue<e> ... = new LinkedList<e>();
    体会思路，用一个 queue 来记录 node。
    注意第 33 - 35 行的注释。
*/
