/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int start = 0,end = s.length() - 1;
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return helper(s,start,end - 1) || helper(s,start + 1,end);
            }
        }
        return true;
    }

    private boolean helper(String s, int start, int end) {
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

}
