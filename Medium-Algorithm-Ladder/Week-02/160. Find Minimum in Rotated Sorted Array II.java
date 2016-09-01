public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[end]) {
                end = mid;
            } else if (num[mid] > num[start]) {
                start = mid;
            } else {
                end -= 1;
            }
        }
        if (num[start] <= num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}

/*
    因为有duplicate，所以mid处值等于最后一个值的时候，只能把end往前移动一位。
    比如 [1,1,1,1,1,1,1,1,0,1,1,1,1,1], 任何的贸然移动都会可能跳过 0 这个最小值.
*/
