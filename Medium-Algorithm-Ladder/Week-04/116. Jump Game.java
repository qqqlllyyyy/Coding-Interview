public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        
        int length = A.length;
        boolean[] result = new boolean[length];
        result[0] = true;
        
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) { // 改成 j<i-1试试
                if (A[j] >= i - j && result[j]) {
                    result[i] = true;
                }
            }
        }
        
        return result[length - 1];
    }
}

/*
    以上是正常的 dynamic programming 的方法， 
    由于每层最多可以跳{A[i]}步，也可以跳0或1步，因此如果能到达最高层，则说明每一层都可以到达。
    有了这个条件，说明可以用贪心法。 代码如下
*/


public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int length = A.length;
        int maxLength = A[0];
        for (int i = 0; i < length; i++) {
            if (i <= maxLength && i + A[i] > maxLength) {
                maxLength = i + A[i];
            }
        }
        return maxLength >= length - 1;
    }
}
