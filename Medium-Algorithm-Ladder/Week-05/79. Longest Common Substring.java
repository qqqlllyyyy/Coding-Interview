public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
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
        
        // result[i][j] is the LCS of A[0:i-1] & B[0:j-1] and the LCS ends with A[i-1]&B[j-1]
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                max = Math.max(max, result[i][j]);
            }
        }
        return max;
    }
}

/*
    我这个解法与九章答案不同
    result[i][j] 表示 A[0:i-1] 与 B[0:j-1] 的最长公共子列（这个最长公共子列必须以 A[i-1] 和 B[j-1] 结尾）
    那么只要 A[i-1] 和 B[j-1] 不相等，result[i][j] 就是0
*/
