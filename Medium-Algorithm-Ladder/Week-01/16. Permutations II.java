class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        int[] visited = new int[nums.size()]; // 重点~~
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(nums);
        helper(result, list, visited, nums);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> list,
                        int[] visited,
                        ArrayList<Integer> nums) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
           // if (list.contains(nums.get(i))) { 
            if (visited[i] == 1 || (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] != 1)){
                continue;
            }
            /*
                上面的判断主要是为了去除重复元素影响。
                比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
                我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
                当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
                不应该让后面的2使用。
            */
            list.add(nums.get(i));
            visited[i] = 1;
            helper(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}

/*
    增加了一个visited来记录访问过的元素。
    特别注意 29 行不能写成 28 行，因为如果有多个重复元素，28行无法判断是哪个。
    而为了唯一性，我们强制要求相同的数字，原来排在前面的，在结果当中也应该排在前面。
*/
