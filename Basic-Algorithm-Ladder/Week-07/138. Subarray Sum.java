public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        
        int len = nums.length;
        ArrayList<Integer> answer = new ArrayList<Integer> ();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                answer.add(map.get(sum) + 1);
                answer.add(i);
                return answer;
            } else {
                map.put(sum, i);
            }
        }
        
        return answer;
    }
}

/*
    记录前n项和，如果有两个和相等，那他们之间的部分就是和为0.
*/
