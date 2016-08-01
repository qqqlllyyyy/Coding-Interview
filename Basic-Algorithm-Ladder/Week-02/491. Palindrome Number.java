public class Solution {
    /**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    
    public boolean palindromeNumber(int num){
        int original = num;
        int reverse = 0;
        while (original != 0) {
            reverse = reverse * 10 + original % 10;
            original /= 10;
        }
        return reverse == num;
    }
}

/*
    获取 reverse 的方法，每次取最后一位数放到已有的 reverse 值最后
*/
