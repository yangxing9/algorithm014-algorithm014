import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/27 0027 17:48
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
public class GenerateParenthesis3 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        return doGen(res,n,0,0,"");
    }

    private List<String> doGen(List<String> res, int n, int left, int right,String str) {
        if (str.length() == 2 * n) {
            res.add(str);
            return res;
        }
        if (left < n) doGen(res,n,left + 1,right,str + "(");
        if (right < left) doGen(res,n,left,right + 1,str + ")");
        return res;
    }

}
