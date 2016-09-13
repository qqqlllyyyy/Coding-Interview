public class Solution {
    public boolean isMatch(String s, String p) {
        
        int indexS = 0, indexP = 0;
        int preS = -1; 
        int preP = -1;
        
        while (indexS < s.length()) {
            // 当两个指针指向完全相同的字符时，或者p中遇到的是?时
            if (indexP < p.length() 
                && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                indexS++;
                indexP++;
            }
            // 如果字符不同也没有?，但在p中遇到是*时，我们记录下*的位置，但不改变s的指针
            else if (indexP < p.length() && p.charAt(indexP) == '*') {
                preP = indexP;
                indexP++;
                //遇到*后，我们用preS来记录*匹配到的s字符串的位置，和不用*匹配到的s字符串位置相区分
                preS = indexS;
                // 这里不能挪动index因为*可以匹配空字符串 
            } 
            // 如果字符不同也没有?，p指向的也不是*，但之前已经遇到*的话，我们可以从preS继续匹配任意字符
            else if (preP != -1) {
                // 用上一个*来匹配，那我们p的指针也应该退回至上一个*的后面
                indexP = preP + 1;
                // 用*匹配到的位置递增
                preS++;
                // s的指针退回至用*匹配到位置
                indexS = preS;
            } else {
                return false;
            }
        }
        
        // 因为1个*能匹配无限序列，如果p末尾有多个*，我们都要跳过
        while (indexP < p.length() && p.charAt(indexP) == '*') {
            indexP++;
        }
        
        // 如果p匹配完了，说明匹配成功
        return indexP == p.length();
    }
}

/*  20160913
    算是比较难的题，但是 Google 面试出过，还是要掌握。
    上面的写法没有用DP，思路简单来说就是:
    1. 二个指针i, j分别指向字符串、匹配公式
    2. 如果匹配，直接2个指针一起前进
    3. 如果匹配公式是*，在字符串中依次匹配即可

    更多有关 DP 的解法解释:
    http://bangbingsyb.blogspot.com/2014/11/leetcode-wildcard-matching.html
    http://www.cnblogs.com/yuzhangcmu/p/4116153.html
    贪心算法:
    https://simpleandstupid.com/2014/10/26/wildcard-matching-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
*/
