import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/18 0018 21:24
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length == 1) return;
        int[] nums2 = new int[nums.length];
        int length = nums.length;
        int index = 0;
        while (index < length) {
            nums2[k++] = nums[index++];
            if (k == length) {
                k = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0 || nums.length == 1) return;
        int first = nums[0];
        int nextIndex = 0;
        int count = 0;
        int oldIndex = 0;
        while (count < nums.length && nextIndex < nums.length) {
            nextIndex = (nextIndex + k) % nums.length;
            if (nextIndex < nums.length) {
                int temp = nums[nextIndex];
                nums[nextIndex] = first;
                count++;
                if (nextIndex == oldIndex) {
                    nextIndex++;
                    oldIndex = nextIndex;
                    first = nums[nextIndex];
                } else {
                    first = temp;
                }
            }
        }
    }

    public static void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}