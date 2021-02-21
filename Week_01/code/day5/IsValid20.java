package day5;

import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/14 0014 19:55
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
public class IsValid20 {

    public static void main(String[] args) {
        String s = "{}{}[](";
        System.out.println(isValid1(s));
    }


    public static boolean isValid2(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                deque.push(')');
            } else if (s.charAt(i) == '['){
                deque.push(']');
            } else if (s.charAt(i) == '{'){
                deque.push('}');
            }else {
                if (deque.isEmpty() || deque.pop() != s.charAt(i)) return false;
            }
        }
        return deque.isEmpty();
    }

    /**
     * 没什么可说的，只要用栈，很简单
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if ((s.length() & 1) == 1) return false;
        Stack<Character> stack = new Stack();
        for (char c: s.toCharArray()){
            if (c == '{'){
                stack.add('}');
            }else if (c == '['){
                stack.add(']');
            }else if (c == '('){
                stack.add(')');
            }else {
                if (stack.empty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * 简单粗暴解法：开心消消乐
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        while (s.contains("[]") || s.contains("{}") || s.contains("()")){
            if (s.contains("[]")) s = s.replace("[]","");
            if (s.contains("{}")) s = s.replace("{}","");
            if (s.contains("()")) s = s.replace("()","");
        }
        return s.isEmpty();
    }
}
