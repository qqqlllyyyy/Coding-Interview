class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int count = 0;
        int start = 0;
        int end = colors.length-1;
        
        while (count < k) {
            int min = Integer.MAX_VALUE; // 这里不要写反了。
            int max = Integer.MIN_VALUE;
            
            for (int i = start; i <= end; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            int left = start, right = end, cur = start;
            while (cur <= right) {
                if (colors[cur] == min) {
                    swap(cur, left, colors);
                    left++;
                    cur++;
                } else if (colors[cur] == max) {
                    swap(cur, right, colors);
                    right--;
                } else {
                    cur++;
                }
            }
            
            count += 2;
            start = left;
            end = right;
        }
    }
    
    
    private void swap(int left, int right, int[] colors) {
        int temp = colors[left];
        colors[left] = colors[right];
        colors[right] = temp;
    }
}


/*
    如果数组中一共有k个值，依次把最小的放到左边，最大的放到右边。
    每进行完一次这个操作就至少完成了两个数的排序（最小和最大）
    所以 count += 2.
*/
