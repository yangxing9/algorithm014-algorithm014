import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/10 0010 10:41
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1,3,2 -> 2,1,3
 * 452631 -> 453126
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,6,5};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路： 1. 首先理解题意，并不是随表找个比当前大的就行，而是找到刚好比当前大的
     *       2. 从末尾开始遍历，找到第一个小于前一个的索引记录为 i，如 4 5 3 6 2 1 找到 3的下标
     *       3. 再次从末尾开始遍历，找到第一个比 nums[i] 的元素，记录为 j
     *       4. 交换 i,j的数
     *       5. 交换后，i对应的位置就是正确的恰好大于原始数组的值，但是i后面的元素还是倒序的，需要转为正序
     *          所以从 i开始到 nums.length - 1 需要逆序下，同时这种情况还包含了 没有更大的排列的情况，即从头到尾逆序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        int start = i + 1,end = nums.length - 1;
        while (start < end){
            swap(nums,start++,end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
