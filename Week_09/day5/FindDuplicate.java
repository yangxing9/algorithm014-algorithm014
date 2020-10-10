import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/9 0009 14:09
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 通过次数100,819提交次数152,974
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) return nums[i];
            pre = nums[i];
        }
        return pre;
    }

    public int findDuplicate2(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + right >>> 1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid){
                    count++;
                }
            }
            if (count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findDuplicate3(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) break;
        }
        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate2(new int[]{1,3,4,2,1}));
    }


}
