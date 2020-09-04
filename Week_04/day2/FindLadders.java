import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/1 0001 15:46
 * 126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class FindLadders {

    public static void main(String[] args) {
        FindLadders demo = new FindLadders();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<List<String>> result = demo.findLadders("hit","cog",wordList);
        System.out.println(result);
    }

    /**
     * 错误解法，只能拿到一条方式
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) return result;
        Deque<String> deque = new ArrayDeque<>();
        Set<String> used = new HashSet<>();
        deque.offer(beginWord);
        used.add(beginWord);
        List<String> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String curStr = deque.poll();
                list.add(curStr);
                if (endWord.equals(curStr)){
                    result.add(list);
                    list = new ArrayList<>();
                }
                char[] chars = curStr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char tmp = chars[j];
                    for (char k = 'a'; k < 'z'; k++) {
                        if (chars[j] == k) continue;
                        chars[j] = k;
                        String newStr = new String(chars);
                        if (used.contains(newStr)) continue;
                        if (wordList.contains(newStr)){
                            used.add(newStr);
                            deque.offer(newStr);
                        }
                    }
                    chars[j] = tmp;
                }
            }
        }
        return result;
    }
}
