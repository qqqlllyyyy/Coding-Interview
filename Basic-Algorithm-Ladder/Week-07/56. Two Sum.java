public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]) + 1, i + 1}; // 用花括号表示list, 不要忘了加一，举几个例子试试
                return result;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        
        int[] result = {}; // 如果没有任何数组满足条件，则返回空list
        return result;
    }
}
