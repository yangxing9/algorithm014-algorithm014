import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/11 0011 17:38
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - 1]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 神奇解法，把每个数字所在的位置 上的值置为 负数，如果已经是负数了就不变
     * 那么不是负数的位置则没出现在数组中，也就找到了未出现的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }


}
