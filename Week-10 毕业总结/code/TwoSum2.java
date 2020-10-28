import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/28 0028 10:59167.
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 通过次数164,142提交次数289,426
 *
 */
public class TwoSum2 {

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        int[] res = twoSum2.twoSum(new int[]{-2,-1,4,5,7},2);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(cache.containsKey(num)){
                return new int[]{cache.get(num) + 1,i + 1};
            }
            cache.put(nums[i],i);

        }
        return new int[]{};
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

}
