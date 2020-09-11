import java.util.HashMap;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/3 0003 20:23
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings2 demo = new NumDecodings2();
        int res = demo.numDecodings("226");
        System.out.println(res);
    }

    public int numDecodings(String s) {
        HashMap<Integer, Integer> memoization = new HashMap<>();
        return getAns(s, 0, memoization);
    }

    private int getAns(String s, int start, HashMap<Integer, Integer> memoization) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        //判断之前是否计算过
        int m = memoization.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        int ans1 = getAns(s, start + 1, memoization);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2, memoization);
            }
        }
        //将结果保存
        memoization.put(start, ans1 + ans2);
        return ans1 + ans2;
    }
}
