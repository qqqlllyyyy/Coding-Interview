public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[] result = new int[n + 1];
        
        result[0] = 1; // Note, here is not 0
        if (s.charAt(0) != '0') { // Don't forget single quote
            result[1] = 1;
        } else {
            result[1] = 0;
        }
        
        for (int i = 2; i < n + 1; i++) {
            result[i] = 0;
            if (s.charAt(i - 1) != '0') {
                result[i] = result[i - 1];
            }
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                result[i] += result[i - 2];
            }
        }
        return result[n];
    }
}

/*
    在正常序列DP题目的解法上略加变化。 循环是从2开始
    每次都要注意判断最后一位是不是 ‘0’ 的情况
    初始化的时候，把 result[0] 定义为 1，
    因为如果最后两位是大于等于10且小于等于26的数，那么 result[i] += result[i-2], 
    需要使得 i=2 的时候 result[i-2] 为 1
*/
