public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        
        int len = nums.length;
        if (len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        
        Pair[] sums = new Pair[len + 1]; // 1. 这里思考下为什么长度是 n+1
        int prev = 0;
        sums[0] = new Pair(0, 0);
        
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        // 注意这种写法，直接把comparator写在排序函数里，按照sum大小排序sums元素
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 1; i <= len; i++) {
            if (sums[i].sum - sums[i - 1].sum < ans) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        
        return res;
        
    }
}


class Pair {
    int sum;
    int index;
    public Pair(int s, int i) {
        sum = s;
        index = i;
    }
}

/*
	用一个长度为 n+1 的类似 dictionary 的东西，每个位置存储两个值，前 n 项和，以及这个 index n.
	然后把这个dictionary按照前n项和排序，最接近两者index之间的部分即为所求。
	-------------------------------------------------------------------------------------------------
	1. sums 长度是 n+1 是因为必须考虑不取任何元素的情况，也就是说可能前 k 个元素之和最接近 0，需要有一个位置存这个0.
	-------------------------------------------------------------------------------------------------
	* 特别注意最后一段给res放入数值的方法:
	如果 nums 是 {1，2，-2}, 那么 sums 是 {(0,0), (1,1), (3,2), (1,3)}
	此时想要的结果是(1,2), 这个结果的区间是从我们找到的较小的index的下一个值开始!
	把 sums 按照 sum 排序后 (1,1)和(1,3) 靠在一起，我们就要从第二个数到第三个数这段区间。
	所以先都减去1，把index排序一下之后，输出结果就是从较小的+1到较大的值。
*/
