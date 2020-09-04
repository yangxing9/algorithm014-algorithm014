/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/3 0003 19:4845. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */
public class Jump2 {

    public static void main(String[] args) {
        Jump2 demo = new Jump2();
        int res = demo.jump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }

    /**
     * 贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxDistance = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance,i + nums[i]);
            if (i == end){
                end = maxDistance;
                count++;
            }
        }
        return count;
    }
}
