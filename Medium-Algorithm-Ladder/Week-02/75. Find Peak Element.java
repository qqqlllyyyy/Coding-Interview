class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 1;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
            //     start = mid;
            // }
            // if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
            //     end = mid;
            // }
            // if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
            //     end = mid;
            // }
            // if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
            //     return mid;
            // }
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
        
    }
}


/*
    中间多种判断情况可以写完后再简化
*/
