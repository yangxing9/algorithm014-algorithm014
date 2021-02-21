import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/31 0031 19:44
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
public class LadderLength {

    public static void main(String[] args) {
        LadderLength5 demo = new LadderLength5();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int result = demo.ladderLength("hit","cog",wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        //将beginWord加入list
        wordList.add(beginWord);
        //begin找end
        Queue<String> queue1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        queue1.add(beginWord);
        visited1.add(beginWord);
        //end找begin
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();
        queue2.add(endWord);
        visited2.add(endWord);
        int depth = 0;
        Set<String> allWord = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            //将节点更少的作为 1
            if (queue1.size() > queue2.size()) {
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> set = visited1;
                visited1 = visited2;
                visited2 = set;
            }
            //开始遍历
            depth++;
            int size = queue1.size();
            while (size-- > 0) {
                String poll = queue1.poll();
                char[] chars = poll.toCharArray();
                //遍历poll的每个字符
                for (int i = 0; i < chars.length; i++) {
                    //保存第i个字符,判断结束后需要还原
                    char temp = chars[i];
                    //将poll的每个字符逐个替换为其他字符
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        //判断替换后的单词
                        String newString = new String(chars);
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        if (visited2.contains(newString)) {
                            return depth + 1;
                        }
                        //如果替换后的单词,存在字典中，则入队并标记访问
                        if (allWord.contains(newString)) {
                            queue1.add(newString);
                            visited1.add(newString);
                        }
                    }
                    //还原第i个字符
                    chars[i] = temp;
                }
            }
        }
        return 0;
    }

    /**
     * 思路：本题能读懂题目是关键，本质就是从 beginWorld 开始，转换为 字典库中存在的，转换一次能得到的结果，用这个结果再去找 下一次转换，直到和目标结果一样
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Deque<String> deque = new ArrayDeque();
        Set<String> used = new HashSet();
        deque.offer(beginWord);
        used.add(beginWord);
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur = deque.poll();
                for (String s : wordList) {
                    if (used.contains(s)) continue;
                    if (!canConvent(cur,s)) continue;
                    if (s.equals(endWord)) {
                        return  ++count;
                    }
                    used.add(s);
                    deque.offer(s);
                }
            }
        }
        return 0;
    }

    private boolean canConvent(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                count++;
                // 有两个地方不一样，则代表一次转换 不行
                if (count > 1){
                    return false;
                }
            }
        }
        // count == 0 代表两个字符串一样
        return true;
    }
}
