import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/8 0008 16:26
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3_1 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum3_1().combinationSum3(3,9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        return doCombinationSum3_1(res,nums,k,n,new ArrayList<Integer>(),0);
    }

    private List<List<Integer>> doCombinationSum3_1(List<List<Integer>> res, int[] nums, int k, int n, ArrayList<Integer> list,int index) {
        if (list.size() == k){
            if (n == 0){
                res.add(new ArrayList<>(list));
            }
            return res;
        }
        for (int i = index; i < nums.length; i++) {
            if (n < nums[i]) break;
            list.add(nums[i]);
            doCombinationSum3_1(res,nums,k,n - nums[i],list,i + 1);
            list.remove(list.size() - 1);
        }
        return res;
    }

}
