/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/10 0010 17:18
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
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int start = 0,end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (start < end){
            if (arr[start] != arr[end]){
                return helper(arr,start,end - 1) || helper(arr,start + 1,end);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean helper(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }

    int count = 0;

    public boolean validPalindrome2(String s) {
        int start = 0,end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (start < end){
            if (arr[start] == arr[end]){
                start++;
                end--;
            }else {
                if (count++ == 0){
                    return validPalindrome2(s.substring(start,end)) || validPalindrome2(s.substring(start + 1,end + 1));
                }
                return false;
            }
        }
        return true;
    }



}
