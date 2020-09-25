import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/24 0024 16:50
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class MaxSubArray3 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,2,-2};
        System.out.println(new MaxSubArray3().maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0){
                end++;
                sum += nums[i];
            }else {
                start = i;
                end = start;
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }
        int[] arr = Arrays.copyOfRange(nums,start,end);
        System.out.println(Arrays.toString(arr));
        return res;
    }

}
