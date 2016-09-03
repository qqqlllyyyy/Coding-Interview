public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        if (A == null || A.length == 0) {
            return result;
        }
        
        int first;
        int second;
        
        // Get 1st value
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return result;
        }
        
        
        // Get 2nd value
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[end] == target) {
            second = end;
        } else if (A[start] == target) {
            second = start;
        } else {
            return result;
        }
        
        result[0] = first;
        result[1] = second;
        return result;
    }
}
