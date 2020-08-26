/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/25 0025 11:49
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace2("0"));
    }

    public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    public static String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
