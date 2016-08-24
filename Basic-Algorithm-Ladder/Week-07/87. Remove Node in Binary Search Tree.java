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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        // 利用两个指针的初始值dummy和root先找到值是value的节点
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left; // 如果找不到值是value的点
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    } 
    
    
    // 这个函数用来找到树中值是'value'的那个节点的parent
    // 因为要保留parent信息，所以要用两个指针'parent'和'node'
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) return parent;
        if (node.val == value) return parent;
        
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        // 如果 node 右边是空的，不论node是在parent的左边还是右边，都可以直接把node删掉
        // 把 node.left 接到parent上去
        if (node.right == null) {
            if (parent.left == node) parent.left = node.left;
            if (parent.right == node) parent.right = node.left;
        }
        else {
            // 如果node右边不空，就找到node右侧所有点中最小的那个，来代替node
            TreeNode temp = node.right;
            TreeNode father = node;
            
            // 从node.right算起，只要其左侧有点，就往左走。
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            
            // 这里说明了需要额外一个'father'的原因，因为那个最左侧的点(temp)
            // 本身可能还有一个右子节点，要把temp.right接到father上
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            
            // 最后两部用我们找到的'temp'来代替'node'的位置
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            
            temp.left = node.left;
            temp.right = node.right;
        }
    }
    
    
}
