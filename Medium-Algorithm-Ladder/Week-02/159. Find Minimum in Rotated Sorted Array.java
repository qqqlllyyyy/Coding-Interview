public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
        
    }
}

/*
    这里注意没有二分法常见的“target”, 是把 nums[mid] 和最后一个值 nums[end] 做比较
*/
