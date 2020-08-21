import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/20 0020 14:15
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] result =  getLeastNumbers2(arr,8);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.offer(arr[i]);
            }else if(arr[i] < queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] result = new int[queue.size()];
        AtomicInteger index = new AtomicInteger(0);
        queue.stream().forEach(element -> result[index.getAndIncrement()] = element);
        return result;
    }

    /**
     * 时间复杂度：O（N），最差情况 遍历 10000 * 3次
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        // 构造最大结果集
        int[] num = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            num[arr[i]]++;
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = 0; i < num.length && index < k; i++) {
            for (int j = 0; j < num[i] && index < k; j++){
                result[index++] = i;
            }
        }
        return result;
    }
}
