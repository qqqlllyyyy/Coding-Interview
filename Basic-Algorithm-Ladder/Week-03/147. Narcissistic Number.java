class Solution {
    /*
     * @param n: The number of digits. 
     * @return: All narcissistic numbers with n digits.
     */
    public ArrayList<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++){
                result.add(i);
            }
            return result;
        }
        
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++){
            int j = i;
            int s = 0;
            while(j > 0){
                s += (int) Math.pow(j % 10, n);
                j /= 10;
            }
            if (s == i) result.add(i);
        }
        return result;
    }
};

/*  2016-08-04
    注意 Math.pow 的返回类型是 double, 所以第18行必须有 (int) !
*/
