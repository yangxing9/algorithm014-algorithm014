import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/18 0018 10:08
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique4 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        return dfs(nums,res,new ArrayList<Integer>(),new boolean[nums.length]);
    }

    private List<List<Integer>> dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, boolean[] used) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) break;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums,res,list,used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
        return res;
    }
}
