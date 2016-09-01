public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
            // Write your code here
            if (A == null || A.length == 0){
                return 0;
            }

            // Find left position, deal with = when move the end.
            int start = 0;
            int end = A.length - 1;

            while (start + 1 < end){
                int mid = (start + end) / 2;
                if(A[mid] >= target){
                    end = mid;
                }else{
                    start = mid;
                }
            }

            int left;
            if (A[start] == target){
                left = start;
            }else if (A[end] == target){
                left = end;
            }else{
                return 0;
            }

            // find right position, deal with the = when move start.
            start = 0;
            end  = A.length - 1;

            while (start + 1 < end){
                int mid = (start + end) / 2;
                
                if(A[mid] <= target){
                    start = mid;
                }else{
                    end = mid;
                }
            }

            int right;
            if (A[end] == target){
                right = end;
            }else {
                right = start;
            }

            return right - left + 1;
        }
}
