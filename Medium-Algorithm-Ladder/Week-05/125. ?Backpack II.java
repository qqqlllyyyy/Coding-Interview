public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        int[][] result = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i][0] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                result[i][j] = result[i - 1][j];
                if (j >= A[i - 1] && result[i - 1][j - A[i - 1]] + V[i - 1] > result[i - 1][j]) {
                    result[i][j] = result[i - 1][j - A[i - 1]] + V[i - 1];
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < m + 1; i++) {
            max = Math.max(max, result[n][i]);
        }
        return max;
        //return result[n][m];
    }
}

/*  20160912
    'result' 这个矩阵的构建思路和 Backpack 这个题类似，横坐标表示用了 A 中前 i 个元素，纵坐标是背包大小。
    但是这里不是 boolean， result[i][j] 表示大小为j的背包恰好能被前i个物体装满时的最大价值。
    所以每次循环，至少 result[i][j] = result[i-1][j-1], 
    另外如果把第i个元素 (A[i-1]) 放进去的话使得总价值增大，就更新 result[i][j]
    这个总价值是 result[i - 1][j - A[i - 1]] + V[i - 1], 因为在位置上要腾空 ‘A[i - 1]’ 的大小给第i个物体
    ？不太理解为啥 23-27 行换成 28 行也可以用。
*/
