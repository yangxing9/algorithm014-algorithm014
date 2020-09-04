/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/3 0003 17:12
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        boolean res = canJump.canJump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }

    int count = 1;

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        boolean[] used = new boolean[nums.length];
        used[0] = true;
        doCanJump(nums,0,used);
        return count == nums.length;
    }

    private void doCanJump(int[] nums, int index, boolean[] used) {
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i < nums.length && !used[index + i]){
                used[index + i] = true;
                count++;
                doCanJump(nums,index + i,used);
            }
        }
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxDistance){
                maxDistance = Math.max(maxDistance,i + nums[i]);
                if (maxDistance >= nums.length -1) return true;
            }
        }
        return false;
    }
}
