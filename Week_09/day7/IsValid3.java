import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid3 {

    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '('){
                deque.push(')');
            }else if (arr[i] == '['){
                deque.push(']');
            }else if (arr[i] == '{'){
                deque.push('}');
            }else {
                if (deque.isEmpty() || arr[i] != deque.pop()){
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

}
