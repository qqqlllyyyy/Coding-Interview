public class Solution {
    /**
     * @param num1 an integer
     * @param num2 an integer
     * @param num3 an integer
     * @return an integer
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // Write your code here
        int max = num1;
        if (num2 > num1){
            max = num2;
        }
        if(num3 > num1){
            max = num3;
        }
        return max;
    }
}
