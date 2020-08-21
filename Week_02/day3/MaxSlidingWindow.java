import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/19 0019 15:07
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[]{1,3,-3,-1,5,3,6,7},3);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 思路：使用双端队列 构建单调栈， 从上向下递减，栈顶元素即为最大值，保持栈最大不超过 K ，大于 k 了，则移除末尾元素
     *      元素从末尾加入，当元素大于末尾元素，说明，该元素需要移动到末尾的上面，保持递减，则移除末尾元素
     *      当迭代到窗口值时，则开始将 栈的第一个元素，加入到结果里面
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        //结果的长度 肯定是 减去 窗口的长度 + 1
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque();
        // 定义 j = 1-k 目的是为了找到窗口的第一个元素
        for (int i = 0,j = 1 - k; i < nums.length; i++,j++) {
            // j > 0,说明此时窗口已经构建出来了，此时判断窗口的第一个元素 是否已经失效了
            if(j > 0 && nums[j - 1] == stack.peekFirst()){
                stack.removeFirst();
            }
            // 当元素大于末尾元素，说明，该元素需要移动到末尾的上面，保持递减，则移除末尾元素
            while (!stack.isEmpty() && nums[i] > stack.peekLast()){
                stack.removeLast();
            }
            // 从末尾加入元素
            stack.addLast(nums[i]);
            // 当达到窗口值时，开始将栈的头部元素加入到结果集
            if (j >= 0){
                res[j] = stack.peekFirst();
            }
        }
        return res;
    }

}
