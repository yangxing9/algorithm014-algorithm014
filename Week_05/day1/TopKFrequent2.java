import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/7 0007 11:29
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKFrequent2 {

    /**
     * 最小堆
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],count);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            }else if (entry.getValue() > map.get(queue.peek())){
                queue.poll();
                queue.offer(entry.getKey());
            }
        }
        return queue.stream().mapToInt(a->a).toArray();
    }

    /**
     * 桶排序，将出现的频率作为 数组下标，元素为list，不停add对应频率的 数字
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],count);
        }
        List<Integer>[] arr = new List[nums.length + 1];
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (arr[entry.getValue()] == null){
                arr[entry.getValue()] = new ArrayList<>();
            }
            arr[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        for (int i = arr.length - 1,j = 0; i >= 0 && j < k; i--) {
            if (arr[i] != null){
                List<Integer> list = arr[i];
                for (int l = 0; l < list.size() && j < k; l++) {
                    res[j] = list.get(l);
                    j++;
                }
            }
        }
        return res;
    }
}
