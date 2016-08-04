public class Solution {
    /**
     * @param num an integer
     * @return an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                result.add(i);
            }
        }
        
        if(num != 1) result.add(num);
        
        return result;
    }
}

/*  2016-07-20
    从2开始一直除，最后别忘了看剩下的 num 是否是1.
*/

/*  2016-08-04
    在 while (num % i == 0){...} 这个循环中，走进花括号的时候i会一直是质数，因为任何的合数都是多个比它小的质数的乘积，
    而i从2上涨到某个合数k的过程中一定会经过比它小的所有质数，
    既然此时num不能被比k小的任意质数整除，num当然也不能被k整除
*/
