class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    
    public int aplusb(int a, int b){
        while (b != 0){
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }
};

/*
    Bit Operation 的运算法则见：http://www.tutorialspoint.com/java/java_basic_operators.htm
    本题解释：https://simpleandstupid.com/2014/12/21/a-b-problem-lintcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
    -------------------------------------------
    x^y //执行加法，不考虑进位。
    (x&y)<<1 //进位操作
    令x=x^y ；y=(x&y)<<1 进行迭代，每迭代一次进位操作右面就多一位0，最多需要“加数二进制位长度”次迭代就没有进位了，此时x^y的值就是结果。
*/
