import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 14:43
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
public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique demo = new PermuteUnique();
        System.out.println(demo.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return doPermuteUnique(nums,new ArrayList<List<Integer>>(),new ArrayList<Integer>(),new boolean[nums.length]);
    }

    private List<List<Integer>> doPermuteUnique(int[] nums, ArrayList<List<Integer>> result, ArrayList<Integer> list,boolean[] used) {
        //递归终结者
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return result;
        }
        // 处理当前层
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 与不重复元素全排列区别  先排序nums，遇到与前一个元素相同的就可以退出当前层了，也就是每次选择，不能选择与自己相同的且被访问过的前几个元素
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                break;
            }
            list.add(nums[i]);
            used[i] = true;
            // 下探下一层
            doPermuteUnique(nums,result,list,used);
            // 清理当前层状态
            list.remove(list.size() - 1);
            used[i] = false;
        }
        return result;
    }
}
