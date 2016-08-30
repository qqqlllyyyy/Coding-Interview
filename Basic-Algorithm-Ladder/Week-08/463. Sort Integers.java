public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        return;
    }
}

/*
    这个不是quick sort的思想，i=0时走完左右的j之后，最小的一定在第一个位置。
    有时候会显示超时，无视之。
*/
