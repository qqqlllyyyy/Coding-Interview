public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target || A[start] == target || A[end] == target) { // 不要忘记检查start和end
                return true;
            }
            if (target > A[start]) {
                if (A[start] < A[mid] && A[mid] < target) {
                    start = mid;
                } else {
                    //end -= 1; // 这里好像写哪个都行。
                    start += 1;
                }
            } else {
                if (target < A[mid] && A[mid] < A[end]) {
                    end = mid;
                } else {
                    //start += 1;
                    end -= 1;
                }
            }
        }
        if (A[start] == target || A[end] == target) {
            return true;
        }
        
        return false;
    }
}


/*
    这个问题在面试中一般不会让实现完整程序，考点是你想不想得到最坏情况。
    只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
*/
