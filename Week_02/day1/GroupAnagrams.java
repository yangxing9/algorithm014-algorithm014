import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/17 0017 19:06
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> cache = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortStr = new String(str);
            List<String> list = cache.getOrDefault(sortStr,new ArrayList<>());
            list.add(strs[i]);
            cache.put(sortStr,list);
        }
        return new ArrayList<>(cache.values());
    }

    public static void main(String[] args) {
    }

}
