public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] nums) {
        // write your code here
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) return "0"; // 这里不能返回0，因为要 return String
        return result.substring(index);
    }
    
    class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2); // String.compareTo
            // 这一步不能把 's2+s1' 和 's1+s2' 换位置
            // 如果换位置就是把小的排在前面，为什么这种写法能保证大的在前？不太理解
        }
    }
}
