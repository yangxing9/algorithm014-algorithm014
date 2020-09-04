import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/31 0031 14:44
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
public class PermuteUnique2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        return doPermuteUnique2(nums,result,new ArrayList<Integer>(),new boolean[nums.length]);
    }

    private List<List<Integer>> doPermuteUnique2(int[] nums, List<List<Integer>> result, ArrayList<Integer> list, boolean[] used) {
        //递归结束
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return result;
        }
        //处理当前层
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) continue;
            // 第二遍出错关键点：忘记加上前一个元素需要被使用的条件
            // 如果不用break，用continue，则可以不加这个条件
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) break;
            used[i] = true;
            list.add(nums[i]);
            //下一层
            doPermuteUnique2(nums,result,list,used);
            //清理状态
            used[i] = false;
            list.remove(list.size() - 1);
        }
        return result;
    }
}
