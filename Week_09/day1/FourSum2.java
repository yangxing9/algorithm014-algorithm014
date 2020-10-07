import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 */
public class FourSum2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) break;
            int max = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max < target) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) break;
                int max2 = nums[i] + nums[j] + nums[length - 1] + nums[length - 2];
                if (max2 < target) continue;
                int k = j + 1,l = length - 1;
                while (k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        while (k < l && nums[k] == nums[++k]);
                        while (k < l && nums[l] == nums[--l]);
                    }else if (sum < target){
                        while (k < l && nums[k] == nums[++k]);
                    }else {
                        while (k < l && nums[l] == nums[--l]);
                    }
                }
            }
        }
        return res;
    }

}
