public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>(); // 第二个尖括号里不写'Integer'也能过
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                //set.remove(down); // 标准答案中有这一步，但不要的话也能通过test
                down--;
            }
            
            int up = nums[i] + 1;
            while (set.contains(up)) {
                //set.remove(up);
                up++;
            }
            longest = Math.max(longest, up - down - 1); // 这里为什么是减1？比如结果是[1,2,3,4], 难道不应该是加1么？
        }
        
        return longest;
    }
}

/*
    理解方法：从第一个数一直循环到最后一个数，对于其中的每个数，都向上找连续数字直到不连续为止，再向下找连续数字直到不连续为止。
*/
