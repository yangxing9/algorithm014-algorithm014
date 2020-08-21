import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/18 0018 19:48
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int newIndex = 1;
        for (int i = 1; i < nums.length;i++ ) {
            if(nums[i] == nums[i - 1]){
                continue;
            }
            nums[newIndex++] = nums[i];
        }
        return newIndex;
    }
}
