package day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @date 2020-8-10
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 *      输入： 2
 *      输出： 2
 *      解释： 有两种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶
 *      2.  2 阶
 * 示例 2：
 *      输入： 3
 *      输出： 3
 *      解释： 有三种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶 + 1 阶
 *      2.  1 阶 + 2 阶
 *      3.  2 阶 + 1 阶
 *
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs6(1));
        System.out.println(climbStairs6(2));
        System.out.println(climbStairs6(3));
        System.out.println(climbStairs6(4));
    }

    public static int climbStairs3(int n) {
        if (n <= 2) return n;
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    public static int climbStairs4(int n) {
        if(n <= 2) return n;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 2; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(n - 1);
    }

    public static int climbStairs5(int n) {
        if(n <= 2) return n;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public static int climbStairs6(int n) {
        if(n <= 2) return n;
        int first = 1;
        int second = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    /**
     *斐波那契数列，使用缓存，或者list，或者数组，能达到
     * 时间复杂度O（n），空间复杂度O（n）
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n <= 2){
            return n;
        }
        // 构造数组
        int[] arr = new int[n];
        // 初始化前两个元素
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            // 第三个元素开始，每个元素为前两个元素之和
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        // 因为数组从0开始，所以 -1
        return arr[n - 1];
    }

    /**
     *斐波那契数列，第n个元素只需要前两个元素的和，使用 变量滚动，可以不用数组
     * 时间复杂度O（n），空间复杂度O（1）
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if(n <= 2){
            return n;
        }
        // 初始化前两个元素，以及结果总个数
        int left = 1,right = 2,result = 0;
        for (int i = 2; i < n; i++) {
            // 第三个元素开始，每个元素为前两个元素之和
            result = left + right;
            left = right;
            right = result;
        }
        return result;
    }

}
