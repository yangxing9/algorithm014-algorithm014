import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/8 0008 14:55
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
public class Combine2 {

    public static void main(String[] args) {
        System.out.println(new Combine2().combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        return doCombine(res,n,k,new ArrayDeque<>(),1);
    }

    private List<List<Integer>> doCombine(List<List<Integer>> res, int n, int k, Deque<Integer> list, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = index; i <= n; i++) {
            list.addLast(i);
            doCombine(res,n,k,list,i + 1);
            list.removeLast();
        }
        return res;
    }
}
