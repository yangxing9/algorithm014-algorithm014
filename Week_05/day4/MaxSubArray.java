/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/10 0010 16:24
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 时间复杂度：O（n^2），超时
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

}
