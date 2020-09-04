import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 15:46
 *  46. 全排列
 *  * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *  *
 *  * 示例:
 *  *
 *  * 输入: [1,2,3]
 *  * 输出:
 *  * [
 *  *   [1,2,3],
 *  *   [1,3,2],
 *  *   [2,1,3],
 *  *   [2,3,1],
 *  *   [3,1,2],
 *  *   [3,2,1]
 *  * ]
 */
public class Permute2 {
    public static void main(String[] args) {
        Permute3 demo = new Permute3();
        int[] nums = new int[]{1,2,3};
        System.out.println(demo.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return doPermute(nums,result,new ArrayList<Integer>(),new boolean[nums.length]);
    }

    private List<List<Integer>> doPermute(int[] nums, List<List<Integer>> result, ArrayList<Integer> list, boolean[] used) {
        //递归终结者
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return result;
        }
        //处理当前层
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            //下一层
            doPermute(nums,result,list,used);
            //清除当前层状态
            list.remove(list.size() - 1);
            used[i] = false;
        }
        return result;
    }
}
