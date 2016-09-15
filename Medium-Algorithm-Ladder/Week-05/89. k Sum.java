public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] result = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i][0][0] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                for (int t = 1; t < target + 1; t++) {
                    result[i][j][t] = result[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        result[i][j][t] += result[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return result[n][k][target];
    }
}

/*
    虽然难度标为 Hard, 但是只要敢用三维的DP矩阵，本题的思路并不是太难理解。
    result[i][j][t] 表示在A的前i个元素中取j个使得和为t的方法种类。
    但是一开始的边界条件只用定义 result[i][0][0] 这一条线么？
*/
