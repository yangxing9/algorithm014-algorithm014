import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/15 0015 16:15
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray2 {

    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        int[] res = relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i],0) + 1);
        }
        int newIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = map.get(arr2[i]);
            for (int j = 0; j < count; j++) {
                arr1[newIndex++] = arr2[i];
            }
            map.remove(arr2[i]);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (Integer key : list) {
            int count = map.get(key);
            for (int j = 0; j < count; j++) {
                arr1[newIndex++] = key;
            }
        }
        return arr1;
    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }
        int newIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            while(arr[arr2[i]] > 0){
                arr1[newIndex++] = arr2[i];
                arr[arr2[i]]--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0){
                arr1[newIndex++] = i;
                arr[i]--;
            }
        }
        return arr1;
    }

}
