class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) return;
        
        int left = 0, right = nums.length - 1;
        int i = 0;
        
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                i++;
                left++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, right);
                //i++;
                right--;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
    特别注意这里的指针 i 只有在 nums[i]=0或1的时候才能往前移动。
    因为要保证 i 左侧的数字都是0或者1， 每当遇到0的时候就把i和左侧第一个不为0的1互换，
    如果换回来了2，i 不能动而把 right 前移，直到把第 i 个位置再和 right 换回 0 或者 1.
*/
