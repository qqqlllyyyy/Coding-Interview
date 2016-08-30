class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length + 1 - k);
        // 特别注意这里最后一个参数进行了大小转化
        // 第k大的元素就是第(n+1-k)小的元素
    }
    
    
    // 这个函数的作用是把从l到r这部分分离大小值。
    // 先找到第一个点的值 nums[l] 作为 pivot 参考值，
    // 然后把所有小于等于 pivot 的值都放到左边，并不断更新left这个指针。
    // 最后把left位置返还pivot的值 
    // (这里需要返还是因为第一次停止更新right的时候，把nums[l]换成了right位置的值，
    // 因此消失了第一个pivot的值)
    // 
    // 如果l从0开始，那么经过这个函数处理后，'left' 位置上的元素就是所谓第'left+1'小的元素。
    private int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[l];
        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }
    
    
    // 这个helper函数实现主要的作用，在l-r这个范围内找到nums中第k小个元素
    // 实际上是二分法。总共执行了logN次
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        } else {
            return helper(nums, l, position - 1, k);
        }
    }
};


/*
	可以直接用 Arrays.sort(nums); return nums[nums.length - k]; 就完成了。
	----------------------------------------------------------------------------
	参考答案应该也是 quick sort 的方法，找到 pivot 再分离大小值。
	其中 helper 这个函数执行了 O(logn) 次，每次都会 call 一遍 partition.
	而 partition 的时间复杂度是 O(n). 总时间就是 O(nlogn).
*/
