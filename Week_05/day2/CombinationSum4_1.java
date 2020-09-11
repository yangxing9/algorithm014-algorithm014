import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/8 0008 17:05
 * 377. 组合总和 Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 */
public class CombinationSum4_1 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum4_1().combinationSum4_2(new int[]{1,3,4},4));
    }

    int count = 0;

    /**
     * 方法一：回溯，超时。。。
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        doCombinationSum4_1(nums,target);
        return count;
    }

    private void doCombinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) break;
            doCombinationSum4_1(nums,target - nums[i]);
        }
    }

    /**
     * 方法二：动态规划
     * 组合成 7 的 可以看成组合成 6 加 1 组合成 5 + 2 。。。
     * 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
     *
     */
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
