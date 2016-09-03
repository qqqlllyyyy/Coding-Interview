public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) { // 注意这里不能加 “|| target == null”, 定义了int之后不能输入null
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            
            if (target >= A[start]) {
                if (A[mid] < target && A[start] < A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (target < A[mid] && A[mid] < A[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}


/*
    *注意17-33行的逻辑，先判断target在断层处的左边还是右边。
    比如在断层以左，则只有 mid 在 start 和 target 之间的时候才可左移 start，否则都右移 end.
    断层以右也类似。
    这个题再写一遍，条件比较多。
*/
