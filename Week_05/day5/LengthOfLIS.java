import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/11 0011 14:36
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 通过次数144,477提交次数319,839
 *
 * [4,10,4,3,8,9] == 3
 * [10,9,2,5,3,4] == 3
 * [1,3,6,7,9,4,10,5,6] == 6
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 保存第i个结尾的元素当前上升子序列个数
        int[] dp = new int[nums.length];
        // 因为是无序的，所以不一定最后一个才是最大的，所以需要对于每一个dp[i]遍历，得到最大值
        int max = 0;
        // 本身即是一种次数,所以默认元素都是1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            // 访问当前元素之前的元素，如果当前元素大于之前的某个元素，则取当前元素，和之前元素 +1 的最大值
            // 当前元素有可能比之前元素 +1 还要大 比如 1 2 3 4 5 1 10，则访问到10这个元素，就不能取 1 这个元素的数量 +1 了
            for (int j = 0; j < i; j++) {
               if (nums[i] > nums[j]){
                   dp[i] = Math.max(dp[j] + 1,dp[i]);
               }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
