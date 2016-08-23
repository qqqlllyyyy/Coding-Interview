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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        return helper(A, 0, A.length - 1);
    }
    
    private TreeNode helper(int[] A, int low, int high) {
        if (low > high) return null; // 这句不能少，如果A是空集，第一步时low=0,high=-1.
        
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, low, mid - 1);
        node.right = helper(A, mid + 1, high);
        return node;
    }
}



// public class Solution {
//     /**
//      * @param A: an integer array
//      * @return: a tree node
//      */
//     public TreeNode sortedArrayToBST(int[] A) {  
//         // write your code here
//         int len = A.length;
//         TreeNode root = null;  
//         root = recursion(A, 1, len, root);
//         A = null; // 这一步起什么作用
//         return root;  
//     }  
//     public TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root)  
//     {  
//         if(lhs <= rhs)  
//         {  
//             int mid = (lhs + rhs + 1) >> 1;  // 不太懂
//             root = new TreeNode(array[mid-1]);  
//             root.left = recursion(array, lhs, mid - 1, root.left);  
//             root.right = recursion(array, mid + 1, rhs, root.right);  
//         }  
//         return root;  
//     }  
// }


/*
    最后被注释的是官方解答，不太明白">>"的用法。
*/
