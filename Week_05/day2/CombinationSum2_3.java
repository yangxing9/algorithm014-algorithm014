import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/8 0008 16:07
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
public class CombinationSum2_3 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_3().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        return doCombinationSum2_3(res,candidates,target,new ArrayList<Integer>(),0);
    }

    private List<List<Integer>> doCombinationSum2_3(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> list, int index) {
        if (target == 0){
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            // 错误点：i > index 而不是 i > 0，且不用used
            /**
             * 解释语句: if i > index && candidates[i] == candidates[i - 1] 是如何避免重复的。
             *
             *
             *
             * 这个避免重复当思想是在是太重要了。
             * 这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
             *                   1
             *                  / \
             *                 2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
             *                /     \
             *               5       5
             *                 例2
             *                   1
             *                  /
             *                 2      这种情况确是允许的
             *                /
             *               2
             *
             * 为何会有这种神奇的效果呢？
             * 首先 i-1 == i 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
             * 可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
             * 因为当第二个2出现的时候，他就和前一个2相同了。
             *
             * 那么如何保留例2呢？
             * 那么就用 i > index 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
             * 例2的两个2是处在不同层级上的。
             * 在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
             * 必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
             * 第一个出现的2的特点就是 i == index. 第二个出现的2 特点是 i > index.
             */
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            doCombinationSum2_3(res,candidates,target - candidates[i],list,i + 1);
            list.remove(list.size() - 1);
        }
        return res;
    }

}
