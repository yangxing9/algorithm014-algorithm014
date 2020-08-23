import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 第二遍
 */
public class GetLeastNumbers2 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(Arrays.toString(getLeastNumbers(arr,3)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.add(arr[i]);
            }else if (arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.stream().mapToInt(a->a).toArray();
    }

}
