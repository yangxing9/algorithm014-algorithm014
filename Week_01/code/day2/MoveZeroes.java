package day2;

import java.util.Arrays;

/**
 *
 * @author yangxing
 * @date 2020-8-10
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,3,8,0,4};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        // 相当于维护新的正确的索引
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                // 遇到非零元素，新索引开始更改元素，由于 i 总是大于等于 j 的，所以不用担心脏数据
                // 这一步的目的是,防止开头如果连续非零元素，导致的额外操作，即是本来元素就不需要移动，此时i和j相等
                if(i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                // 不论是否移动新元素，遇到非零元素，则表示不需要移动，新维护的索引也不需要变动，跟随i自增即可
                j++;
            }
        }
    }
}
