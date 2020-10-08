import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int[] tmp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i] > 0){
                // 此处为 i 下标，并未tmp元素的值
                nums[index++] = i;
                tmp[i]--;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int start = 0,end = nums.length ;
        for (int i = 0;i < end; i++) {
            if (nums[i] == 0){
                swap(nums,i,start);
                start++;
            }else if (nums[i] == 2){
                end--;
                swap(nums,i,end);
                // 当交换过来的是 0 或者 2 ，则需要重新考察当前下标
                if (nums[i] != 1) i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
