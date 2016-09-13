public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        int n = s.length();
        int[] result = new int[n + 1];
        result[0] = -1;
        boolean[][] palindromeSet = getPalindromeSet(s);
        for (int i = 1; i < n + 1; i++) {
            result[i] = i - 1;
            for (int j = 0; j < i; j++){
                if (palindromeSet[j][i]) {
                    result[i] = Math.min(result[i], result[j] + 1);
                }
            }
        }
        return result[n];
    }


    
    private boolean isPalindrome (String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int n = s.length();
        int start = 0;
        int end = n - 1;
        while (start < end) { // 注意这里不是 start + 1 < end, 否则最里面两个无法判断是否相等。
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean[][] getPalindromeSet(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                String sub = s.substring(i, j);
                result[i][j] = isPalindrome(sub);
            }
        }
        return result;
    }
};


/*
    当前解法中 result[i] 表示前i个字符的子列最少需要切几次，result 有 n+1 的长度，
    result[1] 表示第一个字符 (比如'a'不需要切), 所以 result[1] = 0; 因而推出 result[0] = -1;

    注意46行的 j 从 i+1 开始，
    getPalindromeSet() 这个函数的结果的第 [i][j] 个元素表示的是 s.substring(i,j) 是否是回文串
    即第一个字符的index是i, 最后一个字符的index是 j - 1, 这里一定要特别注意！！
*/
