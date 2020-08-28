import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 16:16
 * 39. 组合总和
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
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum demo = new CombinationSum();
        System.out.println(demo.combinationSum(new int[]{4,2,3},7));
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 ) return null;
//        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doCombinationSum(result,candidates,target,new ArrayList<Integer>(),0);
        return result;
    }

    private void doCombinationSum(List<List<Integer>> result,int[] candidates, int target, ArrayList<Integer> list,int index) {
        //递归终结者
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        //处理当前层
        for (int i = index; i < candidates.length; i++) {
            //判断如果当前值比 目标值大，则说明，等会传递到下一层的值 < 0 ，也就是不满足条件了，直接跳过，这一句也直接让递归条件不用判断 target < 0的情况了
            // 如果是排序后的，则可以break;
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            //下探下一层，因为每个元素可重复选择，且总的组合不能重复，则需要began,这种方式，从自己开始
            doCombinationSum(result,candidates,target - candidates[i],list,i);
            //本层状态清理，这种方式更优
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }
}
