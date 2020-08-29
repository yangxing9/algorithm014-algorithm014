import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets demo = new Subsets();
        System.out.println(demo.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        return doSubsets(result,new ArrayList<Integer>(),nums,0);
    }

    private List<List<Integer>> doSubsets(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int index) {
        if (index == nums.length){
            result.add(new ArrayList<>(list));
            return result;
        }
        doSubsets(result,list,nums,index + 1);
        list.add(nums[index]);
        doSubsets(result,list,nums,index + 1);
        list.remove(list.size() - 1);
        return result;
    }
}
