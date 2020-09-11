import java.util.HashMap;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/11 0011 09:50
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
public class NumDecodings2 {

    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '1');
        System.out.println((int) '2');
        System.out.println((int) '9');
        System.out.println((char) 33);
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0'){
            dp[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26){
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }

    public int numDecodings2(String s) {
        return dfs(s,0,new HashMap<Integer,Integer>());
    }

    private int dfs(String s, int index, HashMap<Integer, Integer> map) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (map.get(index) != null) return map.get(index);
        int ans1 = dfs(s,index + 1,map);
        int ans2 = 0;
        if (index < s.length() - 1){
            int ten = (s.charAt(index) - '0') * 10;
            int one = s.charAt(index + 1) - '0';
            if (ten + one <= 26){
                ans2 = dfs(s,index + 2,map);
            }
        }
        map.put(index,ans1 + ans2);
        return ans1 + ans2;
    }

}
