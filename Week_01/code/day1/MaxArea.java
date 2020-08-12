package day1;

/**
 * @author yangxing
 * @date 2020-8-10
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }


    /**
     * 双指针法，夹逼
     * 时间复杂度：O(N)O(N)，双指针总计最多遍历整个数组一次。
     *
     * 空间复杂度：O(1)O(1)，只需要额外的常数级别的空间。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0,j = height.length - 1 ; i < j; ) {
            int area = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
