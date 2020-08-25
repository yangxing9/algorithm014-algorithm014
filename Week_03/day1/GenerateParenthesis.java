import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/24 0024 15:56
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {


    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        generate(0, 0, n, "",list);
        return list;
    }

    /**
     * 思路：先枚举所有组合可能，再考虑下去除不符合条件的
     *      符合条件的：
     *          1，先添加左括号，添加左括号时,左括号还有可用
     *          2，再添加右括号，添加右括号时,存在的右括号的数量小于左括号
     * @param left
     * @param right
     * @param max
     * @param str
     * @param list
     */
    private void generate(int left, int right,int max, String str,ArrayList<String> list) {
        if (left >= max && right >= max) {
            list.add(str);
            return;
        }
        if (left < max) generate(left + 1,right, max, str + "(",list);
        if (right < left) generate(left,right + 1, max, str + ")",list);
    }
}
