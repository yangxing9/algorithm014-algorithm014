
import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/6 0006 17:26
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
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
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength5 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));

        int res = new LadderLength5().ladderLength("hit","cog",list);
        System.out.println(res);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> worldSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;
        Set<String> cache = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(beginWord);
        cache.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                char[] curArr = queue.poll().toCharArray();
                for (int i = 0; i < curArr.length; i++) {
                    char tmp = curArr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        curArr[i] = j;
                        String newStr = String.valueOf(curArr);
                        if (newStr.equals(endWord)) return count;
                        if (cache.contains(newStr)) continue;
                        if (worldSet.contains(newStr)){
                            queue.offer(newStr);
                            cache.add(newStr);
                        }
                    }
                    curArr[i] = tmp;
                }
            }
        }
        return 0;
    }

}
