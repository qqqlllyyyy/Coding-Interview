class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        subsetsHelper(result, list, S, 0);
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                                ArrayList<Integer> list,
                                ArrayList<Integer> S,
                                int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < S.size(); i++) {
            if (i != index && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            subsetsHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


/*
    与上一题不同的就是 24-26 行，每次执行向后循环时只去不同值。
    比如有三个2，第一个2向后选择时会选到第二个2，移除第二个2之后要跳过第三个2，否则会有相同子集出现.
*/

/*  20160829
    这里注意第13行，对于ArrayList<Integer>不能直接用Arrays.sort()来进行排序
    需要用Collections.sort();
    Collections.sort operates on a List, and Arrays.sort operates on an array
*/
