/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new IntervalComparator());
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= last.end) {
                last.end = Math.max(last.end, curt.end);
            } else {
                result.add(last);
                last = curt;
            }
        }
        
        result.add(last); // 不要忘记还要把最后的 last 再加入结果中
        return result;
    }
    
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

}

/*
    学习 Comparator 以及 Collections.sort() 的用法，如果想要sort一个无默认定义大小关系的list，比如题目中的 Interval 的 List，
    就要自行定义大小关系，也就是 implements 一个 Comparator 并定义 compare 函数。
    这里的定义是，对于两个interval a和b，大小关系即为左边界的关系
    ----------------------------------------------------------------------------------------------
    把给定 intervals 按照左边界（start）做排序后，再循环每个区间：
        1. 如果当前区间（curt）和上一个区间（last）有交集，就合并之，取两者最大的右边界作为右边界。
        2. 如果 curt 和 last 无交集，即 curt.left>last.right，那么last不会再增大了，把last放入结果中，再令last=curt即可。
*/
