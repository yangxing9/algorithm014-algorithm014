import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        Map<Character,String> cache = new HashMap<>();
        cache.put('2',"abc");
        cache.put('3',"def");
        cache.put('4',"ghi");
        cache.put('5',"jkl");
        cache.put('6',"mno");
        cache.put('7',"pqrs");
        cache.put('8',"tuv");
        cache.put('9',"wxyz");
        return doLetterCombinations(digits,"",result,0,cache);
    }

    private List<String> doLetterCombinations(String digits,String letter, List<String> result, int index,Map<Character,String> cache) {
        //递归终止
        if (index == digits.length()){
            result.add(letter);
            return result;
        }
        //处理当前层
        String string = cache.get(digits.charAt(index));
        for (int i = 0; i < string.length(); i++) {
            //下一层
            doLetterCombinations(digits,letter + string.charAt(i),result,index + 1,cache);
        }
        //清理当前层状态
        return result;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();
        Map<Character,String> cache = new HashMap<>();
        cache.put('2',"abc");
        cache.put('3',"def");
        cache.put('4',"ghi");
        cache.put('5',"jkl");
        cache.put('6',"mno");
        cache.put('7',"pqrs");
        cache.put('8',"tuv");
        cache.put('9',"wxyz");
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("");
        for (int i = 0; i < digits.length(); i++) {
            String tmp = cache.get(digits.charAt(i));
            int size = deque.size();
            for(int k = 0;k < size;k++) {
                String pre = deque.poll();
                for (int j = 0; j < tmp.length(); j++) {
                    deque.offer(pre + tmp.charAt(j));
                }
            }
        }
        return new ArrayList<>(deque);
    }

    public static void main(String[] args) {
        LetterCombinations demo = new LetterCombinations();
        List<String> result = demo.letterCombinations2("23");
        System.out.println(result);
    }
}
