public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        int[][] result = new int[m + 1][n + 1];
        
        for (int i = 0; i < m + 1; i++) {
            result[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            result[0][i] = 0;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        
        return result[m][n];
    }
}

/*
    作为双序列型动态规划题，本题也有点绕。
    result[i][j] 表示 T 的前j个字符组成的子列在 S 的前i个字符中出现了几次。
    要注意22行的递推关系，如果最后一个字符相等，那么就有两种可能，
    一种是用上了 T 的最后一个字符，这种情况下是 result[i-1][j-1]
    另一种是没用上 T 的最后一个字符，此时是 result[i-1][j]
*/
