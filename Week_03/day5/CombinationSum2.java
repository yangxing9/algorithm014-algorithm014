import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 19:08
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 demo = new CombinationSum2();
        System.out.println(demo.combinationSum2(new int[]{2,5,2,1,2},5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        return doCombinationSum2(new ArrayList<List<Integer>>(), new ArrayList<Integer>(), candidates,0,target);
    }

    private List<List<Integer>> doCombinationSum2(List<List<Integer>> result, ArrayList<Integer> list, int[] candidates, int index, int target) {
        if (target == 0){
            result.add(new ArrayList<>(list));
            return result;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            // 不包含重复的组合，所以，遇到可选择与前一个相同，则不选
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            // 因为每个元素只能用一次，所以下一个元素从 i+1 开始
            doCombinationSum2(result,list,candidates,i + 1,target - candidates[i]);
            list.remove(list.size() - 1);
        }
        return result;
    }
}
