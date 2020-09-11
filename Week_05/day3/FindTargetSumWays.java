import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/9 0009 16:10
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        FindTargetSumWays demo = new FindTargetSumWays();
        System.out.println(demo.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        doDfs(nums,0,S,0);
        return count;
    }

    private void doDfs(int[] nums, int sum, int s, int index) {
        if (index == nums.length) {
            if (sum == s){
                count++;
            }
            return;
        }else {
            doDfs(nums,sum - nums[index],s,index + 1);
            doDfs(nums,sum + nums[index],s,index + 1);
        }
    }
}
