import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 11:02
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public static void main(String[] args) {
        Permute demo = new Permute();
        int[] nums = new int[]{1,2,3};
        System.out.println(demo.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return doPermute(nums,result,new ArrayList<>());
    }

    private List<List<Integer>> doPermute(int[] nums, List<List<Integer>> result, List<Integer> list) {
        // 递归终结者
        if (list.size() == nums.length){
            result.add(list);
            return result;
        }
        // 处理当前层
        for (int i = 0; i < nums.length; i++) {
            // 此处若新建一个list，则后续不用清理本层状态
            List<Integer> newList = new ArrayList<>(list);
            // 判断该数字是否已经用过了，不能重复
            if (newList.contains(nums[i])){
                continue;
            }
            newList.add(nums[i]);
            // 下探下一层
            doPermute(nums,result,newList);
            // 清理本层状态
//            list.remove(list.size() - 1);
        }
        return result;
    }
}
