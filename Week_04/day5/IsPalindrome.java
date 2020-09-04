import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/4 0004 15:34
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome demo = new IsPalindrome();
        System.out.println(demo.isPalindrome3(123321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] arr = String.valueOf(x).toCharArray();
        for (int i = 0,j = arr.length - 1; i < j; i++,j--) {
            if (arr[i] != arr[j]) return false;
        }
        return true;
    }

    /**
     * 从后开始，不断取末尾数字，* 10 + 个位 ，保证前面一半长度大于后面一半
     */
    public boolean isPalindrome2(int x) {
        // 必须先把末尾为0的排除了，不然下面计算有问题，比如 10
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int lastNum = 0;
        while (x > lastNum){
            lastNum = lastNum * 10 + x % 10;
            x /= 10;
        }
        //   当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        //   例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        //   由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == lastNum || x == lastNum / 10;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int max = 1;
        int tmp = x;
        while (tmp >= 10) {
            max *= 10;
            tmp /= 10;
        }
        int first = 0;
        int end = 0;
        while (x != 0){
            // 拿到头一个数字
            first = x / max;
            // 拿到末尾数字
            end = x % 10;
            if (first != end) return false;
            // 去掉头数字
            x %= max;
            // 去掉尾数字
            x /= 10;
            // 去掉了两个数字，所以 /100
            max /= 100;
        }
        return true;
    }


}
