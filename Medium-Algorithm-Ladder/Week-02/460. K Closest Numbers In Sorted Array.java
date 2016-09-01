public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0 || k == 0) { // 这里不要忘记k=0的情况，直接返回[]
            return result;
        }
        int start = 0;
        int end = A.length - 1;
        int firstPosition = -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                firstPosition = mid;
                break;
            }
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (firstPosition == -1) { // 这里不能少这一行
        // 否则上面的 firstPosition=mid 之后还会走下面几行，从而把firstPosition变成start或end
            if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
                firstPosition = start;
            } else {
                firstPosition = end;
            }
        }
        
        result[0] = A[firstPosition];
        int count = 1;
        
        int left = firstPosition - 1;
        int right = firstPosition + 1;
        
        while (left >= 0 && right <= A.length - 1 && count < k) {
            if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                result[count] = A[left];
                left--;
            } else {
                result[count] = A[right];
                right++;
            }
            count++;
        }
        
        // When there is no element on the right, shift the left side.
        while (left >= 0 && count < k) {
            result[count] = A[left];
            left--;
            count++;
        }
        
        // When there is no element on the left, shift the right side.
        while (right < A.length && count < k) {
            result[count] = A[right];
            right++;
            count++;
        }
        
        return result;
        
    }
}

/*
    选出最接近的位置后再用双指针。
*/
