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
            nums[result++] = entry.getKey(); // 这里效果其实相当于这两句：nums[result]=...; result++; 
        }
        return result;
    }
}

/*  2016-07-16
    HashMap 的写法:           HashMap<Integer, Boolean>
    插入语句:                 map.put(nums[i], true);
    牢记循环HashMap元素的语法:  for(Map.Entry<Integer, Boolean> entry : map.entrySet()){}
    ----------------------------------------------------------------------------------
    ‘entry’ 是一个 mapping 组对，它是一个 'Map'.
    这里的 Map 是一个 Interface, Interface 中读取 variable 的方法与 class 类似，但 Interface 中定义的 method 必须要在 Interface 被某个类 implement 后才可读，详见: http://tutorials.jenkov.com/java/interfaces.html
    Map 中定义了读 key 和读 value 的 method: getKey() & getValue(). 官方文档见 https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
    HaspMap 中定义了获取所有 mapping 集合的 method: entrySet(). 官方文档见: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html <--- 但这里的getKey()其实是Map.Entry的方法，而不是HashMap的
*/

/*  2016-08-03
    使用HashMap是因为map.put(nums[i], true)这一步，可以把之前相等的值覆盖，比如 nums[1] = nums[3], 写入3的时候把前者覆盖，
    map中组对的个数就是unique number的数目
    Map.Entry是Map的一个nested class, 它有 getKey() 和 getValue() 这两个方法
*/
