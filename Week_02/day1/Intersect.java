import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/17 0017 13:54
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersect {

    public static void main(String[] args) {
        int[] result = intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 时间复杂度：O(m+n)O(m+n)，其中 mm 和 nn 分别是两个数组的长度。需要遍历两个数组并对哈希表进行操作，哈希表操作的时间复杂度是 O(1)O(1)，因此总时间复杂度与两个数组的长度和呈线性关系。
     *
     * 空间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个数组的长度。对较短的数组进行哈希表的操作，哈希表的大小不会超过较短的数组的长度。为返回值创建一个数组 intersection，其长度为较短的数组的长度
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] resutlt = new int[Math.min(nums1.length,nums2.length)];
        int index = 0,index1 = 0,index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] < nums2[index2]){
                index1 ++;
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else{
                resutlt[index++] = nums1[index1];
                index1 ++;
                index2 ++;
            }
        }
        return Arrays.copyOfRange(resutlt,0,index);
    }


    /**
     * 适用于元素大小小于10的
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        // 缓存小数组，遍历大数组
        if(nums2.length < nums1.length){
            return intersect3(nums2,nums1);
        }
        // 构建结果集，最大也就是小数组的长度，长度可能超出实际所需，所以需要最后裁剪下
        int[] result = new int[nums1.length];
        int index = 0;
        int[] cache = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            cache[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            // 缓存中有该元素，则看下有几个该元素，添加一个，则对应的数量减少一个，如减少到为0，则说明可以移除了
            if(cache[nums2[i]] > 0){
                result[index++] = nums2[i];
                cache[nums2[i]] -= 1;
            }
        }
        // 需要从0，到index截取下
        return Arrays.copyOfRange(result, 0, index);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] resutlt = new int[Math.min(nums1.length,nums2.length)];
        int index = 0,index1 = 0,index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] < nums2[index2]){
                index1 ++;
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else{
                resutlt[index] = nums1[index1];
                index ++;
                index1 ++;
                index2 ++;
            }
        }
        return Arrays.copyOfRange(resutlt,0,index);
    }
}
