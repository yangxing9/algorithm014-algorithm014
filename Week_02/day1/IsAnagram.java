/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/17 0017 18:45
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cache = new int[26];
        for (int i = 0;i < s.length();i++){
            cache[s.charAt(i) - 'a'] += 1;
            cache[t.charAt(i) - 'a'] -= 1;
        }
        for (int ss : cache){
            if (ss != 0){
                return false;
            }
        }
        return true;
    }
}
