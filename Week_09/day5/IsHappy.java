package day5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/9 0009 10:37
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {

    /**
     * 输入：19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 本题隐含条件，有可能一直无限循环，即 n 变成之前出现过的数字，也就是类似链表中的环
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            if (set.contains(n)) return false;
            set.add(n);
            n = helper(n);
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int fast = helper(n);
        int slow = n;
        while (fast != 1){
            if (fast == slow) return false;
            fast = helper(helper(fast));
            slow = helper(slow);
        }
        return true;
    }

    private int helper(int n) {
        int res = 0;
        while (n != 0){
            int mod = n % 10;
            res += mod * mod;
            n /= 10;
        }
        return res;
    }

}
