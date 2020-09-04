import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/3 0003 11:24
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        int res = demo.lengthOfLongestSubstring("bbb");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int max = 0;
        int end = 0;
        for (int start = 0; start < s.length(); start++) {
            int index = s.charAt(start);
            end = Math.max(arr[index], end);
            // 记录该字符对应的索引 + 1
            arr[index] = start + 1;
            // 记录当前字符到上一个不重复的字符的距离
            max = Math.max(max, start - end + 1);
        }
        return max;
    }
}
