import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/27 0027 17:29
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    public static void main(String[] args) {
        Combine2 demo = new Combine2();
        List<List<Integer>> result = demo.combine(6,3);
        System.out.println(result);
    }



    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        doCommbine(n,k,1,new Stack<>(),result);
        return result;
    }

    private void doCommbine(int n, int k, int index, Stack<Integer> list,List<List<Integer>> result) {
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            doCommbine(n,k,i + 1,list,result);
            list.pop();
        }
    }

}
