public class Solution {
    /**
     * @param str a string
     * @return a string
     */
    public String lowercaseToUppercase2(String str) {
        // Write your code here
        StringBuilder sb = new StringBuilder(str);
        for (int index = 0; index < sb.length(); index++) {
            char c = sb.charAt(index);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(index, Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}

/*
    熟悉 StringBuilder 这个操作 string 的类: 
    StringBuilder objects are like String objects, except that they can be modified. Internally, these objects are treated like variable-length arrays that contain a sequence of characters. At any point, the length and content of the sequence can be changed through method invocations.

    StringBuilder: charAt, setCharAt, toString
    Character:     isLowerCase, toUpperCase
*/
