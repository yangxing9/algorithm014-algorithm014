/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 17:46
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits2(38));
    }

    /**
     * 递归
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    /**
     * 循环
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        while (num >= 10){
            int sum = 0;
            while (num > 0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static int addDigits4(int num){
        if(num < 10) return num;
        int a = num % 10;
        int b = num / 10;
        return addDigits4(a+b);
    }

    /**
     * 在数学中，数根(又称位数根或数字根Digital root)是自然数的一种性质，换句话说，每个自然数都有一个数根。
     *
     * 数根是将一正整数的各个位数相加（即横向相加），若加完后的值大于10的话，则继续将各位数进行横向相加直到其值小于十为止[1]，
     *      或是，将一数字重复做数字和，直到其值小于十为止，则所得的值为该数的数根。
     *
     * @param num
     * @return
     */
    public int addDigists3(int num){
        return (num - 1) % 9 + 1;
    }
}
