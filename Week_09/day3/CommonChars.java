import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/14 0014 09:50
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 通过次数21,003提交次数29,
 */
public class CommonChars {

    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        List<String> res = commonChars.commonChars(new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"});
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> commonChars(String[] A) {
        int[] min = new int[26];
        Arrays.fill(min,Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            String cur = A[i];
            int[] arr = new int[26];
            for (int j = 0; j < cur.length(); j++) {
                arr[cur.charAt(j) - 'a']++;
            }
            // 关键点在于每次取每个字符串的出现元素的最小值
            for (int j = 0; j < min.length; j++) {
                min[j] = Math.min(min[j],arr[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

}
