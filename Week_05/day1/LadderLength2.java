import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/7 0007 09:50
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
public class LadderLength2 {

    public static void main(String[] args) {
        System.out.println(ladderLength2("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog","xot","xit","xig","xog"))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        int count = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur = deque.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String tarStr = wordList.get(j);
                    if (used.contains(tarStr)) continue;
                    if (!canConvent(cur,tarStr)) continue;
                    if (tarStr.equals(endWord)) {
                        return count;
                    }
                    deque.offer(tarStr);
                    used.add(tarStr);
                }
            }
        }
        return 0;
    }

    private static boolean canConvent(String cur, String tarStr) {
        if (cur.length() != tarStr.length()) return false;
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != tarStr.charAt(i)){
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }

    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Deque<String> deque1 = new ArrayDeque<>();
        deque1.offer(beginWord);
        Deque<String> deque2 = new ArrayDeque<>();
        deque2.offer(endWord);
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        Set<String> used2 = new HashSet<>();
        used2.add(endWord);
        int count = 1;
        Set<String> allWord = new HashSet<>(wordList);
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            if (deque1.size() > deque2.size()){
                Deque<String> tmp = deque1;
                deque1 = deque2;
                deque2 = tmp;
                Set<String> usedTmp = used;
                used = used2;
                used2= usedTmp;
            }
            int size = deque1.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur = deque1.poll();
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char tmp = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        arr[j] = k;
                        String newStr = new String(arr);
                        if (used.contains(newStr)) continue;
                        if (used2.contains(newStr)) {
                            return count;
                        }
                        if (allWord.contains(newStr)) {
                            used.add(newStr);
                            deque1.offer(newStr);
                        }
                    }
                    arr[j] = tmp;
                }
            }
        }
        return 0;
    }
}
