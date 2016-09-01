public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = 0;
        for (int wood : L) {
            max = Math.max(max, wood);
        }
        
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (canCut(L, k, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (canCut(L, k, end)) {
            return end;
        } else if (canCut(L, k, start)) {
            return start;
        } else {
            return 0;
        }
    }
    
    
    private boolean canCut(int[] L, int k, int length) {
        int result = 0;
        for (int wood : L) {
            result += (wood / length);
        }
        return result >= k;
    }
}

/*
    理清思路就不难，从 1 到最长的木棒长度，用二分法找到‘能分割’的最长长度。
    ‘能分割’这个属性是通过另一个函数来实现.
*/
