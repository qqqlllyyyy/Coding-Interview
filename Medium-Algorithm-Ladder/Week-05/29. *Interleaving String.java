public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] result = new boolean[m + 1][n + 1];
        result[0][0] = true;
        
        for (int i = 1; i < m + 1; i++) {
            // 特别注意不能直接把 result[i][0] 设置为 true
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && result[i - 1][0]) {
                result[i][0] = true;
            } else {
                result[i][0] = false;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && result[0][i - 1]) {
                result[0][i] = true;
            } else {
                result[0][i] = false;
            }
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                result[i][j] = false; // 这一行不能忘记
                
                // if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                //     result[i][j] = result[i - 1][j];
                // }
                // if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                //     result[i][j] = result[i][j - 1];
                // }
                
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && result[i - 1][j]) {
                    result[i][j] = true;
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && result[i][j - 1]) {
                    result[i][j] = true;
                }
            }
        }
        
        return result[m][n];
    }
}

/*
    双序列DP问题，思路与其它几道类似，
    result[i][j] 表示 s1[0:i-1] 与 s2[0:j-1] 能否组合拼成 s3[0:i+j-1]
    但是本题有好几个容易忽略的点，要特别注意：
    
    1. 一开始不要忘记检查是否 s1.length() + s2.length() == s3.length
    2. result 矩阵初始化的时候一定不要把 result[i][0] 直接设为 true，要看 s1[0:i-1] 是否等于 s3[0:i-1] !!!
    3. 35行不能忘记，把每个点先设置为 false. 因为可能后面的两个 if 条件都不满足。
    4. 44-49 行的判断语句一定不能写成 37-42 行， 因为如果两个 if 条件都满足，但是 result[i - 1][j] = true, result[i][j - 1] = false,
       那么 result[i][j] 就以后一个为准，这显然是不对的。
*/
