package day6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int result = largestRectangleArea3(new int[]{2,1,5,6,2,3});
        System.out.println(result);
    }

    /**
     * 枚举宽
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight,heights[j]);
                area = Math.max(area,(j - i + 1)*minHeight);
            }
        }
        return area;
    }

    /**
     * 枚举高
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int right = i;
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]){
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]){
                right++;
            }
            area = Math.max(area,(right - left + 1) * heights[i]);
        }
        return area;
    }

    /**
     * 单调栈
     * @param heights
     * @return
     */
    public static int largestRectangleArea3(int[] heights) {
        int maxArea = 0;
        int[] newHeight = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            newHeight[i] = heights[i -1];
        }
        Deque<Integer> stack = new ArrayDeque();
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]){
                int heightIndex = stack.pop();
                maxArea = Math.max(maxArea,(i - stack.peek() - 1) * newHeight[heightIndex]);
            }
            stack.push(i);
        }
        return maxArea;
    }


}
