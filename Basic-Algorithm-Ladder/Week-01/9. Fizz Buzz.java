class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */

    public ArrayList<String> fizzBuzz(int n){
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0){
                result.add("fizz buzz");
            } else if (i % 5 == 0){
                result.add("buzz");
            } else if (i % 3 == 0){
                result.add("fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}

/*
    将int变为string输出时需要用 String.valueOf(i) 这个函数
*/
