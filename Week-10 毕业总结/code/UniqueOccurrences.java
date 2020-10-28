import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/28 0028 09:59
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * 通过次数23,667提交次数32,687
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        UniqueOccurrences p = new UniqueOccurrences();
        boolean res = p.uniqueOccurrences(new int[]{-1000,2,2,-1000,-1000,1000});
        System.out.println(res);
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] tar = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            tar[arr[i] + 1000]++;
        }
//        Set<Integer> set = new HashSet<>();
        // 优化，使用boolean数组代替hashset，降低内存使用
        boolean[] set2 = new boolean[arr.length];
        for (int i = 0; i < tar.length; i++) {
            if (tar[i] == 0) continue;
            if (set2[tar[i]]){
                return false;
//            if (set.contains(tar[i])){
//                return false;
            }else {
                set2[tar[i]] = true;
//                set.add(tar[i]);
            }
        }
        return true;
    }

}
