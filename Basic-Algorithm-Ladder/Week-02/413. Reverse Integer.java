public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int original = n;
        int reverse = 0;
        while (original != 0) {
            int temp = reverse * 10 + original % 10;
            original /= 10;
            
            if (temp / 10 != reverse) {
                return 0;
            }
            reverse = temp;
        }
        return reverse;
    }
}

/*
    与 491 题类似的思想。
    但要注意，如果结果 overflow, 就一定是把 reverse 乘以 10 再加上 original 个位数这一步溢出，所以每进行这一步的时候要检查下运算后的结果除以 10 是不是运算前的 reverse.
*/
