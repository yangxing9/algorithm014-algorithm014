import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 第二遍
 */
public class MaxSlidingWindow2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        if (k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0,j = 1 - k; i < nums.length; i++,j++) {
            if(j > 0 && nums[j - 1] == deque.peekFirst()){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (j >= 0){
                result[index++] = deque.peekFirst();
            }
        }
        return result;
    }
}
