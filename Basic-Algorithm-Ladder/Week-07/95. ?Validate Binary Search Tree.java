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

// 定义这个辅助类的原因是Solution中的辅助函数要返回几个不同类型的值:is_bst, min, max
// Java 可以像 Python 一样同时返回几个不同类型的变量么?
class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    ResultType(boolean is_bst, int minValue, int maxValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    } // 为什么函数的定义前面不用加 "public void" ?
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        ResultType r = helper(root);
        return r.is_bst;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
            // 注意这里的最大最小值不能写反！！
            // root==null时，minValue要设置成最大值，为了以后与别的‘minValue’共同
            // 取较小值时取不到null本身的minValue。
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            return new ResultType(false, 0, 0); // 返回false时，min和max是多少应该无所谓
        }
        if (root.left != null && left.maxValue >= root.val ||
            root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
            // 一开始想不写这个if判断条件中的‘...!=null’,但是不行：
            // 如果input只有一个Interger.MAX_VALUE, 那么就会因为"left.maxValue >= root.val"这一句出错。
            // 可是如果把"<="变成"<",那当input是[1, 1]的时候就会返回true，
            // 而BST中所有的值都不能相等。
            // 因此这里要特别注意！
        }
        
        return new ResultType(true, 
                            Math.min(root.val, left.minValue),
                            Math.max(root.val, right.maxValue));
    }
}




// version 2 Traverse
public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}


// 我的解法
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) return true;
        
        if (root.val != Integer.MIN_VALUE && root.val != Integer.MAX_VALUE){
            if (root.val <= min || root.val >= max) return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}


/*
	1. Line 14. Java 可以像 Python 一样同时返回几个不同类型的变量么?
	2. Line 18. 为什么函数的定义前面不用加 "public void"? 如果加了前缀就无法通过测试。
	3. 第二种答案的方法不太理解，为何每次检查完左侧之后再更新母节点值(lastVal)?
	----------------------------------------------------------------------------
	最后是我的解法，可以通过test，但是处理MAX_VALUE的时候显然不能这么草率，
	比如如果input是[MAX_VALUE, MAX_VALUE]两个相同的最大值的话，第二次递归应该要返回false，但我的方法会返回true。
	4. 怎么简单的改进？
*/
