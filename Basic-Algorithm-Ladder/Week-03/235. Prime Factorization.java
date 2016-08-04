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

/*
    从2开始一直除，最后别忘了看剩下的 num 是否是1.
*/
