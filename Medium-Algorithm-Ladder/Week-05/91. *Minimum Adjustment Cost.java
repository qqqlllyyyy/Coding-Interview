public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] result = new int[n + 1][100];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 100; j++) {
                // 表示把第i个数修改成j+1所需要的最小花费
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // for (int i = 0; i < n + 1; i++) {
        //     result[i][0] = 0;
        // }
        
        for (int i = 0; i < 100; i++) {
            result[0][i] = 0;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 100; j++) {
                
                int lowerBound = Math.max(0, j - target);
                int upperBound = Math.min(99, j + target); 
                for (int k = lowerBound; k <= upperBound; k++) {
                    result[i][j] = Math.min(result[i][j], result[i - 1][k] + Math.abs(j-A.get(i-1)));
                }
            }
        }
        
        int resultValue = Integer.MAX_VALUE;
        for (int j = 0; j < 100; j++) {
            resultValue = Math.min(resultValue, result[n][j]);
        }
        return resultValue;
    }
}

/*
    有点绕，result[i][j] 表示前i个数，把第i个数调整为 j+1 (因为总列数是100而非101) 并且满足条件 (相邻两数之差不大于k) 的最小cost.
    仔细思考下递推关系，那么想要获得 result[i][j], 也就是 A.get(i-1) 要变成 j+1,
    从而 A.get(i-2) 可能的取值必须在 和 j+1 的差值不超过 k
    也就有了第31行的递推。

    几个要注意的点:
    初始化条件是 21-23 行，不要有 17-19 行，因为如果 A 中有数，把第i个修改成0的花费显然不是0，
    把一个空的数改成任何数的cost是0，所以 result[0][i]=0
    第29行是99，因为j这个坐标在30-31行用到了，要放到第二个中括号中去，而result只有100列，最大 column index 是99
*/
