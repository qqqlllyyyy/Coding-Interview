public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    
    public int deduplication(int[] nums){
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        int result = 0;
        for(Map.Entry<Integer, Boolean> entry : map.entrySet()){
            nums[result++] = entry.getKey();
        }
        return result;
    }
}

/*
    HashMap 的写法:           HashMap<Integer, Boolean>
    插入语句:                 map.put(nums[i], true);
    牢记循环HashMap元素的语法:  for(Map.Entry<Integer, Boolean> entry : map.entrySet()){}
    ----------------------------------------------------------------------------------
    ‘entry’ 是一个 mapping 组对，它是一个 'Map'.
    这里的 Map 是一个 Interface, Interface 中读取 variable 的方法与 class 类似，但 Interface 中定义的 method 必须要在 Interface 被某个类 implement 后才可读，详见: http://tutorials.jenkov.com/java/interfaces.html
    Map 中定义了读 key 和读 value 的 method: getKey() & getValue(). 官方文档见 https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
    HaspMap 中定义了获取所有 mapping 集合的 method: entrySet(). 官方文档见: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
*/
