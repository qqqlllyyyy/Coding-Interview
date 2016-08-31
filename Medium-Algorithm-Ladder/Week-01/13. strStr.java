class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null){
        return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        
        // 这个注释的方法会检测 target.length() 到 source.length() 之间的不必要的部分，可以pass, 但Leetcode会有runtime error.
        // for (int i = 0; i < source.length() - target.length() + 1; i++){
        //     // j = 0 is necessary to rule out the corner case at the last step.
        //     int j = 0;
        //     for (j = 0; j < target.length(); j++){
        //         if ( source.charAt(i+j) != target.charAt(j) ){
        //             break;
        //         }
        //     }
        //     if (j == target.length()){
        //         return i;
        //     }
        // }
        
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(0)) {
                int j = 0;
                for (j = 0; j < target.length(); j++) {
                    if (i + j >= source.length() || source.charAt(i + j) != target.charAt(j)) {
                        break;
                    } 
                }
                if (j == target.length()) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}
