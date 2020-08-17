/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/17 0017 09:45
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap42 {

    public int trap(int[] height) {
        for (int i = 0; i < height.length; i++) {
            if (i == 0 ){
                while (height[i++] == 0);
            }
        }
        return 0;
    }
}
