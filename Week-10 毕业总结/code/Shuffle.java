/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/3 0003 15:35
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 *
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 *
 *
 * 提示：
 *
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * 通过次数31,036提交次数36,406
 */
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < n){
                nums1[index1++] = nums[i];
            }else {
                nums2[index2++] = nums[i];
            }
        }
        index1 = 0;
        index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                nums[i] = nums1[index1++];
            }else {
                nums[i] = nums2[index2++];
            }
        }
        return nums;
    }

    public int[] shuffle2(int[] nums, int n) {
        int i = 0,j = n;
        int[] res = new int[2 * n];
        for (int k = 0; k < res.length; k++) {
            if (k % 2 == 0){
                res[k] = nums[i++];
            }else {
                res[k] = nums[j++];
            }
        }
        return res;
    }

}
