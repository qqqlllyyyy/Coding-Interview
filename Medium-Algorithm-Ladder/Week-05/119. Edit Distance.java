public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            result[0][i] = i;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int min = Math.min(result[i - 1][j], result[i][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = Math.min(result[i - 1][j - 1], min);
                } else {
                    result[i][j] = Math.min(result[i - 1][j - 1] + 1, min);
                }
            }
        }
        
        return result[m][n];
    }
}

/*  20160911
    本周几题按照九章算法班第五节课的思路都非常清晰，再听一遍。
    双序列型动态规划，
    result[i][j] 表示的是 word1 的前i个字符与 word2 的前j个字符最少需要多少次变换
    注意 result 的大小为 (m+1) * (n+1) 以及初始情况的设定
*/
