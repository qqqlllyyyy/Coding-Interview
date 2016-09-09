public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return -1;
        }
        
        int m = triangle.length;
        int[][] result = new int[m][m];
        result[0][0] = triangle[0][0];
        
        // Initialization
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + triangle[i][0];
            result[i][i] = result[i - 1][i - 1] + triangle[i][i];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) { //这里注意是 j<i 而不是 j<i+1 也不是 j<m
                result[i][j] = Math.min(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
            }
        }
        
        int resultInt = result[m - 1][0];
        for (int j = 1; j < m; j++) {
            resultInt = Math.min(resultInt, result[m - 1][j]);
        }
        return resultInt;
        
    }
}

/*
    第23行注意是 j<i 而不是 j<i+1 也不是 j<m
    因为第i行第i个的右上方没有元素，即 i-1 行没有第i个元素
*/
