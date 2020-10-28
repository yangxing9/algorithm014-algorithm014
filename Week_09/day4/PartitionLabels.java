import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/23 0023 16:34
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        List<Integer> res = p.partitionLabels("ababcbacadefegdehijhklij");
        res.forEach(System.out::println);
    }

    /**
     * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
     *
     * 在得到每个字母最后一次出现的下标位置之后，可以使用贪心算法和双指针的方法将字符串划分为尽可能多的片段，具体做法如下。
     *
     * 从左到右遍历字符串，遍历的同时维护当前片段的开始下标 {start}start 和结束下标 {end}end，初始时 {start}={end}=0start=end=0。
     *
     * 对于每个访问到的字母 cc，得到当前字母的最后一次出现的下标位置 {end}_cend c，则当前片段的结束下标一定不会小于 {end}_cendc，因此令 {end}=max({end},{end}_c)end=max(end,end c)。
     *
     * 当访问到下标 {end}end 时，当前片段访问结束，当前片段的下标范围是 [{start},{end}][start,end]，长度为 {end}-{start}+1end−start+1，将当前片段的长度添加到返回值，然后令 {start}={end}+1start=end+1，继续寻找下一个片段。
     *
     * 重复上述过程，直到遍历完字符串。
     *
     */
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0,end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end,arr[S.charAt(i) - 'a']);
            if (i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

}
