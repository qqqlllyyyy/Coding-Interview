public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        
        // Arrays.sort(A);
        // Arrays 这个 class 中给出了很多对 array 操作的方法比如sort和search
        // 这个默认的'sort()'方法中使用的是dual-pivot quick sort. 
        // 平均时间复杂度还是 O(nlogn).
        
        int low = 0;
        int high = A.length - 1;
        quickSort(A, low, high);
        
    }
    
    private void quickSort(int[] A, int low, int high) {
        
        if (A == null || A.length == 0 || low >= high) return;
        
        int middle = low + (high - low) / 2;
        int pivot = A[middle];
        
        int i = low, j = high;
        while (i <= j) {
            while (A[i] < pivot) { // 不能加等号
                i++;
            }
            while (A[j] > pivot) {
                j--;
            }
            if (i <= j) { // 这里如果去掉等于号就会出错？为啥
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++; // 最后这两部去掉的话也会'Time Limit Exceeded'.
                j--;
            }
        }
        
        if (low < j) quickSort(A, low, j);
        if (high > i) quickSort(A, i, high);
    }
}

/*
    标准的 quick sort 写法。
    ？如果第 29&32 行加了等号，或者 35 行去掉等号，或者去掉 39&40 行，都会出现 Error: 'Time Limit Exceeded' 
    (Test case: [3,2,1,4,5])
    ----------------------------------------------------------------------
    九章答案耍流氓，标准写法来自于：http://www.programcreek.com/2012/11/quicksort-array-in-java/
    这里定义了low和high之后可以只sort数组中的一部分。
*/
