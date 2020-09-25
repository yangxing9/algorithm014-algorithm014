/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 11:24
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome2 {

    public static void main(String[] args) {
        System.out.println(new IsPalindrome2().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        if (s.length() == 0) return true;
        for (int i = 0,j = s.length() - 1; i < j ; i++,j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (i < j && s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

}
