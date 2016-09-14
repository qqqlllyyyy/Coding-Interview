public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            result[i][0] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            result[0][i] = 0;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = Math.max(result[i][j], result[i - 1][j - 1] + 1);
                }
            }
        }
        
        return result[m][n];
    }
}

/*
    做了好几道双序列的动态规划题目，思想都是类似的
    result[i][j] 表示 A[0:i-1] 和 B[0:j-1] 的最长公共子序列
    注意区分 ‘公共子序列 subsequence’ 与 ‘公共子列 substring’ 的区别。
    与 79 题做法略有区别.
*/
