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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>(); // 这里的尖括号里写不写 'TreeNode' 都能过
    private TreeNode curt;
    
    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;
        
        return node;
    }
}

/*
    题目比较难理解，按照“右上->左下”的防线把tree分层。
    先思考用什么数据结构来做，因为我们是从root开始，所以肯定不是先进先出，要先找到最小的点，第一个返回最小的点(最左侧)
    所以应该是后进先出，选择 Stack。
*/

/*  20160902
    注意第29行的条件 'current!=null';
    因为在 stack.pop() 后如果 stack 空了之后 current 会是 stack 最后pop出的元素的右子节点。
    显然这个时候 hasNext() 应该return true；但是只判断 stack 是否为空是不足的。
*/

/*  20160908
    34行的循环条件是 curt != null 而不是 curt.left != null
    不要忘记第41行，因为必须把 curt 往右移动一位，否则会一直在最左边的leaf点
*/
