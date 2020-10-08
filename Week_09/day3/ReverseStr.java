import java.net.CookieHandler;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例:
 *
 * 输入: s = "abcd efg", k = 2
 * 输出: "ba cd fe g"
 *
 * 输入: s = "abcd efg", k = 4
 * 输出: "dcba efg"
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 通俗一点说，每隔k个反转k个，末尾不够k个时不动；
 */
public class ReverseStr {

    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg",4));
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0,step = 2 * k; i < arr.length; i += step) {
            int end = Math.min(i + k - 1,arr.length - 1);
            reverse(arr,i,end);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }

}
