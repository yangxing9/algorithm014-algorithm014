import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/1 0001 13:52
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis2 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        return doGenerateParenthesis2(n,result,0,0,"");
    }

    private List<String> doGenerateParenthesis2(int n, List<String> result, int left, int right,String str) {
        // 第二遍错误地方：应当是 2*n 长度
        if (str.length() == 2 * n){
            result.add(str);
            return result;
        }
        if (left < n) doGenerateParenthesis2(n,result,left + 1,right,str + "(");
        if (right < left) doGenerateParenthesis2(n,result,left,right + 1,str + ")");
        return result;
    }
}
