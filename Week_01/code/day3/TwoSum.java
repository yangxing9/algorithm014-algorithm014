package day3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yangxing
 * @date 2020-8-11
 *
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = twoSum(arr,9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 使用缓存降低复杂度，达到 O（n）
     *
     * 注意！注意！注意！ 审题！审题！审题！，要的是数组下标，不是值！
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(cache.containsKey(num)){
                return new int[]{cache.get(num),i};
            }
            cache.put(nums[i],i);

        }
        return new int[]{};
    }

}
