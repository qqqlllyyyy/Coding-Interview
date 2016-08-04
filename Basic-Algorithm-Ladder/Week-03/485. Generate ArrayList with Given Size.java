public class Solution {
    /**
     * @param size an integer
     * @return an array list
     */
    public ArrayList<Integer> generate(int size) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= size; ++i)
            result.add(i);
        return result;
    }
}

/*
    注意第八行与九章官网提供的答案不同，参考答案是 List<> = ArrayList<> 用到了 Polymorphism, 这一步没有错。
    但由于第六行定义了 function 的 output 必须是 ArrayList, 所以参考答案写法无法通过 test.
*/
