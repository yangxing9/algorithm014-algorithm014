/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/19 0019 11:14
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeTwoList {

    public static void main(String[] args) {
        int[] nums1 = {7,8,9,0,0,0};
        int[] nums2 = {2,5,6};
        merge2(nums1,3,nums2,3);
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        // 构建最大结果集
        int[] resut =  new int[m+n];
        //双指针法
        int i = 0,j = 0;
        while(i < m && j < n) {
            resut[index++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        // 剩余的直接加在末尾即可
        if (i == m){
            while (j < n){
                resut[index++] = nums2[j++];
            }
        }else if(j == n){
            while (i < m){
                resut[index++] = nums1[i++];
            }
        }
        // 重新复制给nums1
        for(int k = 0;k < nums1.length;k++){
            nums1[k] = resut[k];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,j = n - 1,index = m + n - 1;
        while(i >= 0 && j >= 0)  nums1[index--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        if (i < 0) System.arraycopy(nums2,0,nums1,0,j + 1);

    }
}
