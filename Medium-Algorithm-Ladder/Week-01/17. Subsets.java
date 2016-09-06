class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, list, nums, 0);
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                                ArrayList<Integer> list,
                                int[] nums,
                                int index) {
        result.add(new ArrayList<Integer>(list)); // 
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1); // 注意这里是i+1,不是index+1
            list.remove(list.size() - 1);
        }
    }
}

/*
    wrong (看下一条) -> 注意第22行，放到result中的只能是ArrayList。
    本题的默认输出格式是 ArrayList<ArrayList<Integer>>, 比较容易，对于List<List<...>>的输出参考Leetcode的同名题。
*/

/*  20160829
    如果第22行不initialize一个新的object的话，最终结果会是[[],[],[],...[]]因为list只是一个指针，
    所有对于list的操作都会对其指向的object操作。
    从而在最后remove完所有数字后，list永远是空集。
*/

/*  20160906
    22行再次出错，忘记用 new ArrayList<Integer>(list) 而直接用的 list;
    25行最后直接用 i, 忘记加1
*/
