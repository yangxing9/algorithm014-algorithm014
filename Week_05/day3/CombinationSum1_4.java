import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/9 0009 14:0039. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class CombinationSum1_4 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        return doDfs(res,candidates,target,new ArrayList<Integer>(),0);
    }

    private List<List<Integer>> doDfs(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> list,int index) {
        if (target == 0){
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            doDfs(res,candidates,target - candidates[i],list,i);
            list.remove(list.size() - 1);
        }
        return res;
    }
}
