import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int moreNum = nums.length / 2;
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = cache.getOrDefault(nums[i],0) + 1;
            if (count > moreNum) return nums[i];
            cache.put(nums[i],count);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int moreNum = nums.length / 2;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;) {
            int count = 1;
            while (i < nums.length - 1 && nums[i] == nums[++i]){
                count++;
                if (count > moreNum) return nums[i];
            }
        }
        return nums[0];
    }



    public static void main(String[] args) {
        MajorityElement demo = new MajorityElement();
        int result = demo.majorityElement2(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
    }


}
