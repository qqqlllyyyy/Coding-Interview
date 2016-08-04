public class Solution {
    /**
     * @param k an integer
     * @return all amicable pairs
     */
    public List<List<Integer>> amicablePair(int k) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();//这里试试把第二个list改成arraylist
        for (int i = 2; i <= k; ++i) {
            int amicable = this.factorSum(i); //这里试试加上‘this.’
            if (amicable <= i || amicable > k) continue;
            if (this.factorSum(amicable) == i) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(amicable);
                result.add(pair);
            }
        }
        return result;
    }
   
    public int factorSum(int n){
        int sum = 1;
        for(int i = 2; i * i < n; i++){
            if (n % i == 0){
                if (i * i == n) {
                    sum += i;
                } else {
                    sum += i;
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}

/*
    第10行和12行的 'this.' 都可以去掉
    第8行等式右侧的 ArrayList<List<...>> 不能改成 ArrayList<ArrayList<...>> 或者 List<List<...>>
    因为本来定义的内部可以是一切List<>以及List<>的subclass, 比如LinkedList<>,就不能把它限制成为里面只有ArrayList<>,外部可以变成ArrayList。
*/
