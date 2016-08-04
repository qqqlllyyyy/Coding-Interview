public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        
        if (str == null || str.length() < 1) return 0;
        
        // trim white spaces
        str = str.trim();
        
        char flag = '+';
        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
		    flag = '-';
		    i++;
	    } else if (str.charAt(0) == '+') {
		    i++;
	    }
        
        // use double to store result
        double result = 0;
        
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        if (flag == '-')
		    result = -result;
 
	    // handle max and min
	    if (result > Integer.MAX_VALUE)
		    return Integer.MAX_VALUE;
 
	    if (result < Integer.MIN_VALUE)
		    return Integer.MIN_VALUE;
 
	    return (int) result;
        
    }
}


/*
    (int) 命令只能作用于 char 型上，不能用于 String。
    19，21 行要注意如果 str 第一个字符是正负号，i 就需要从 1 开始循环。
    27 行 while 条件中的 i 不要写成 0。
    28 行注意要求 str 在第 i 位的数字必须用 (str.charAt(i) - '0'), 如果用 (int) str.charAt(i) 返回的会是一个很大的数值，是 str.charAt(i) 在 ascii 表中的 key。
    
    本题应该是标准的 String 变成 int 的函数方法了。
    ---------------------------------------------------------
    Integer 这个 class 中有一个方法是 parseInt(), 但如果本题直接 return Integer.parseInt(str) 的话对于 overflow 的极大值或者极小值会出错。
*/
