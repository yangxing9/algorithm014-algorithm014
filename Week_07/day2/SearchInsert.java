/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/22 0022 15:16
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
//        System.out.println(new SearchInsert().searchInsert(arr,5));
        System.out.println(new SearchInsert().searchInsert(arr,0));
//        System.out.println(new SearchInsert().searchInsert(arr,7));
//        System.out.println(new SearchInsert().searchInsert(arr,0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
        return left;
    }

}
