import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * top k 问题集合
 */
public class TopKQuestion {

    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 思路1：排序（快排）
     * 思路2：最小堆
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k){
                queue.offer(nums[i]);
            }else if(nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    /**
     * 面试题 17.14. 最小K个数
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     * 思路1：快排
     * 思路2：最大堆
     */
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.offer(arr[i]);
            }else if(arr[i] < queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.stream().mapToInt(a->a).toArray();
    }

    /**
     * 973. 最接近原点的 K 个点
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     *
     * （这里，平面上两点之间的距离是欧几里德距离。）
     *
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     * 思路：换汤不换药，还是top k问题
     */
    public static int[][] kClosest(int[][] points, int K) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < points.length; i++) {
            int distance = (points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            map.put(i,distance);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (queue.size() < K){
                queue.offer(entry.getKey());
            }else if(entry.getValue() < map.get(queue.peek())){
                queue.poll();
                queue.offer(entry.getKey());
            }
        }
        int[][] result = new int[queue.size()][2];
        for (int i = 0; i < result.length;i++) {
            int tmp = queue.poll();
            result[i] = points[tmp];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{-5,4},{-6,-5},{4,6}};
        System.out.println(Math.sqrt(61));
        System.out.println(Math.sqrt(52));
//        int[][] result = kClosest(arr,2);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }
    }
}
