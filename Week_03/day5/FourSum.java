import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 19:39
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum demo = new FourSum();
        System.out.println(demo.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) break;
            int max = nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            if (max < target) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int h = nums.length - 1;
                int min2 = nums[i] + nums[j] + nums[k] + nums[k + 1];
                if (min2 > target) break;
                int max2 = nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2];
                if (max2 < target) continue;
                while (k < h){
                    int cur = nums[i] + nums[j] + nums[k] + nums[h];
                    if (cur == target){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[h])));
                        while (k < h && nums[k] == nums[++k]);
                        while (k < h && nums[h] == nums[--h]);
                    }else if (cur < target){
                        while (k < h && nums[k] == nums[++k]);
                    }else {
                        while (k < h && nums[h] == nums[--h]);
                    }
                }
            }
        }
        return result;
//        return doFourSum(new ArrayList<List<Integer>>(),nums,0,target,new ArrayList<>(),0);
    }

    private List<List<Integer>> doFourSum(ArrayList<List<Integer>> result, int[] nums,int sum, int target, ArrayList<Integer> list,int index) {
        if (list.size() == 4 && target == sum){
            result.add(new ArrayList<>(list));
            return result;
        }
        for (int i = index; i < nums.length; i++) {
            if (sum > target) break;
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            doFourSum(result,nums,sum + nums[i],target,list,i + 1);
            list.remove(list.size() - 1);
        }
        return result;
    }
}
