import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/2 0002 11:11
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        List<String> res = wordBreak.wordBreak("catsanddog",list);
        System.out.println();
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        res = dfs(res,s,wordDictSet,0,new HashMap<Integer, List<List<String>>>());
        for (int i = 0; i < res.size(); i++) {
            List<String> world = res.get(i);
            list.add(String.join(" ",world));
        }
        return list;
    }

    private List<List<String>> dfs(List<List<String>> res, String s, Set<String> wordDict, int index,Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index >= s.length()) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int j = index; j < s.length(); j++) {
                String tar = s.substring(index, j + 1);
                if (wordDict.contains(tar)) {
                    List<List<String>> tmp = dfs(res, s, wordDict, j + 1, map);
                    for (List<String> nextWordBreak : tmp) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(tar);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }


//    public List<String> wordBreak(String s, List<String> wordDict) {
//         List<String> res = new ArrayList<>();
//         Set<String> wordDictSet = new HashSet<>(wordDict);
//         return dfs(res,s,wordDictSet,0,0);
//     }
//
//     private List<String> dfs(List<String> res, String s, Set<String> wordDict, int index,int last) {
//         if (index >= s.length()){
//             res.add(s);
//             return new ArrayList<>(res);
//         }
//         for (int j = index; j < s.length(); j++) {
//             String tar = s.substring(last,j + 1);
//             if (wordDict.contains(tar)){
//                 dfs(res,j + 1 >= s.length() ? s : s.substring(0,j + 1) + " " + s.substring(j + 1,s.length()),wordDict,j + 2,j + 2);
//             }
//         }
//         return res;
//     }

}
