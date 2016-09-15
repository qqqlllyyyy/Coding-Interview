public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        boolean[][] result = new boolean[n + 1][m + 1];
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                result[i][j] = false;
            }
        }

        result[0][0] = true;
        // for (int i = 0; i < n + 1; i++) {
        //     result[i][0] = true;
        // }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                result[i][j] = result[i - 1][j];
                if (j >= A[i - 1] && result[i - 1][j - A[i - 1]]) { // Don't forget the '>=' condition
                    result[i][j] = true;
                }
            }
        }
        
        for (int i = m; i >= 0; i--) {
            if (result[n][i]) {
                return i;
            }
        }
        return 0;
    }
}

/*  20160912
    背包型动态规划，result[i][j] 表示 A 中前 i 个元素是否可以填满大小为 j 的背包。
    有点绕，多体会体会.

    可以把第18行换成 19-21 行，即背包大小为0的时候肯定可以填满。
*/
