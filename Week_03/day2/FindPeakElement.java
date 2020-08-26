import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/25 0025 13:50
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[deque.peekFirst()]){
                deque.push(i);
            }else {
                return deque.peekFirst();
            }
        }
        return deque.peekFirst();
    }

    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0,r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
