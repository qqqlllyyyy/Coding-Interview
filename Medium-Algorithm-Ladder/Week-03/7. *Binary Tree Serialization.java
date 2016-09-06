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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        // Remove null's
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#"); // 上面和下面的单字节都可以用单引号
                // 但是这里append的东西有两个字符，必须看做string，用双引号!
            } else {
                sb.append(',');
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) { // 用 '.equals(...)' 来检查string的内容相同，
        // 而不是'==', 后者只是用来检测两个String的reference是否相同!!
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(","); //换成size()试试
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) { // 不能用vals[i]!="#"
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
}


/*
    仔细看 deserialize 的部分，
    serialize的时候并不一定非要把整个 full tree (即 2^(k+1) - 1 个元素) 完整的存入string中
    只需要存一个 complete tree 就可以了 （每个节点都有0或是2个孩子。）
    如果一个节点不是空，哪怕其左右子节点都是null，也把这两个 null 都存进去 (存成'#')
    --------------------------
    deserialize 的时候，设置一个index指针，queue中只存真节点(跳过null)，
    每当 vals 中走过了两个元素，就把 index 往前移动一位。
    --------------------------
    可能疑惑的地方：如果一个tree不是full tree, 缺失的部分会不会影响结果 (即能不能分清每个元素是第几层的)。
    其实不会，因为我们假设第 k 层只有 m 个不为null的节点 (最多 2^(k-1) 个)， 
    那么我们在下一层就一定会存储 2m 个 String, 一切都是确定的
*/
