public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here 
        int n = s.length();
        boolean[] result = new boolean[n + 1];
        
        result[0] = true;
        for (int i = 1; i < n + 1; i++) {
            result[i] = false;
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (result[j] && dict.contains(substring)) {
                    result[i] = true;
                }
            }
        }
        return result[n];
    }
}

/*
    result[i] 表示前 i 个字符组成的 string 能否被dict切分。
    这种做法会超时，还可以优化
    因为其实dict中的单词并不会特别长(假设最长的单词只有20个字符)，
    那么在第14行的时候，如果i非常大，没必要让j从0开始，只要从 i-20 开始就行了，因为最长的单词的长度都不会超过20
    下面是答案优化的办法:
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
}
