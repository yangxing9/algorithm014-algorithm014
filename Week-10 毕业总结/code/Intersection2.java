import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/2 0002 14:46
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
        Set<Integer> list = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i++]);
                j++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        Intersection2 d = new Intersection2();
        int[] res = d.intersection2(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(res));
    }
}
