class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(nums);
        helper(result, list, nums, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> list,
                        ArrayList<Integer> nums,
                        int index) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return; // 这里记得要 return, 不然就会无限跑下去。 <-- 其实不用return，不会一直跑下去。
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

/*  20160829
    其实这个题目的helper函数中不需要有第四个index元素了，没有意义。
    因为每次在helper函数中都是从第一个循环。
*/
