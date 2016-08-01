public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    
    public int secondMax(int[] nums){
        
        if(nums.length <= 1){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max_2 = max;
                max = nums[i];
            } else if (nums[i] >= max_2){
                max_2 = nums[i];
            }
        }
        return max_2;
        
    }
}

/*
    Integer.MIN_VALUE
*/
