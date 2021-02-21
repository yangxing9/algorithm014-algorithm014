import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/24 0024 17:17
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class FindShortestSubArray3 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(new FindShortestSubArray3().findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 1;
            while (j < nums.length - 1 && nums[j] == nums[j + 1]){
                count++;
                j++;
            }
            i = j;
            if (count > max){
                list.clear();
                list.add(nums[i]);
            }else if (count == max){
                list.add(nums[i]);
            }
            max = Math.max(max,count);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int num = 0;
            boolean start = false;
            for (int j = 0; j < arr.length; j++) {
                if (list.get(i) == arr[j]){
                    start = true;
                    num++;
                }
                if (start){
                    count++;
                }
                if (num == max){
                    start = false;
                }
            }
            res = Math.min(res,count);
        }
        return res;
    }

    public int findShortestSubArray2(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] arr = map.getOrDefault(nums[i],new int[3]);
            arr[0] += 1;
            if (arr[0] == 1) arr[1] = i;
            arr[2] = i;
            maxCount = Math.max(maxCount,arr[0]);
            map.put(nums[i],arr);
        }
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Integer, int[]> entry: map.entrySet()){
            if (entry.getValue()[0] == maxCount){
                res = Math.min(res,entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return res;
    }

}
