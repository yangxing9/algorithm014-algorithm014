import java.util.HashMap;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/8 0008 09:57
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
 *
 * [28,54,7,-70,22,65,-6]
 * 100
 * [0,0,0,0,0,0,0,0,0,0]
 * 0
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},0));
    }

    public int subarraySum(int[] nums, int k) {
       int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 思路类似两数之和， 缓存前 i 个数之和，查看缓存中是否有 用当前 累加的和 - k的值，有就说明，当前累加 - 之前累加 == k
     * 比如： 1 2 3 4 5  k = 5  那就是 前一个数之和为 1 ，前 3个数之和为 6 ，就是查看map中是否有 6 - k 也就是 1 ，加上前 n 个数为 1 的count
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return count;
    }

}
