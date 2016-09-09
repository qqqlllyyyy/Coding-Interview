public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        
        for (int i = 0; i < length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (result[j] + 1 > result[i]) {
                        result[i] = result[j] + 1;
                    }
                }
            }
        }
        
        // Get Largest
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }
}

/*
    思考一下，这个result序列中第i位元素表示的是什么
    表示的是从0到i位置的序列中最长的并且以最后一个元素结尾的子列的长度。
    所以不能直接输出 result[length - 1], 因为最长子列不一定以最后一个元素结尾。
*/
