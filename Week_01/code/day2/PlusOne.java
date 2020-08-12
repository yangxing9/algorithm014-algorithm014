package day2;

import java.util.Arrays;

/**
 * @author yangxing
 * @date 2020-8-11
 *  66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 9;
        arr[1] = 9;
        arr[2] = 9;
        int[]  s = plusOne(arr);
        System.out.println(Arrays.toString(s));
    }

    /**
     * 存在一下几种情况：
     * 1： 123
     * 2： 299
     * 3： 999
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9){
                // 元素为9 则改为0，表示需要进一，继续迭代
                digits[i] = 0;
            }else{
                // 元素不为9，则直接自增，结束循环，返回数组
                digits[i] ++;
                return digits;
            }
        }
        // 表示999，这种情况，数组总元素加一
        digits = new int[digits.length + 1];
        // 不需要再拷贝新数组，new一个新数组，默认元素为0，刚好满足情况，首位赋值为1
        digits[0] = 1;
        return digits;
    }
}
