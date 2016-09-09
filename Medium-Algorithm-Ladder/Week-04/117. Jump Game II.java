public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int length = A.length;
        int[] result = new int[length];
        result[0] = 0;
        
        for (int i = 1; i < length; i++) {
            result[i] = -1;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    result[i] = result[j] + 1;
                    break; // 不能忘了这一句
                }
            }
        }
        return result[length - 1];
    }
}

/*
    以上是正常的DP的方法，注意第21行
    找到第一个能到达 i 位置的就停止, 因为如果 m<n, 那么 result[m] 一定小于等于 result[n]
    ------------------------------
    以下是贪心法
*/

public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }
}
