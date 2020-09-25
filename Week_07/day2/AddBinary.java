/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/22 0022 16:50
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1,j = b.length() - 1;i >= 0 || j >= 0;i--,j--){
            int aNum = i < 0 ? 0 : a.charAt(i) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = aNum + bNum + remainder;
            remainder = sum / 2;
            sb.append(sum % 2);
        }
        if (remainder != 0) sb.append(remainder);
        return sb.reverse().toString();
    }

}
