class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        dict.put(1, 0);
        dict.put(2, 1);
        if (n <= 1) return 0;
        if (n == 2) return 1;
        for (int i = 3; i <= n; i++) {
            int temp = dict.get(i - 1) + dict.get(i - 2);
            dict.put(i, temp);
        }
        return dict.get(n);
    }
}

