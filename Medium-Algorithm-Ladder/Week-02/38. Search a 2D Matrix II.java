public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = column - 1;
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            start = 0;
            end = column - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] > target) {
                    end = mid;
                } else if (matrix[i][mid] < target) {
                    start = mid;
                } else {
                    count++;
                    break;
                }
            }
            if (matrix[i][start] == target || matrix[i][end] == target) {
                count += 1;
            }
        }
        return count;
    }
}

/*
    这个题还有个时间复杂度很低的高级算法，还未来得及研究。
*/
