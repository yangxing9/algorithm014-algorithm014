import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/12/8 0008 20:34
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 */
public class SplitIntoFibonacci {

    public static void main(String[] args) {
        List<Integer> res = splitIntoFibonacci("123456579");
       System.out.println(res);
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        char[] arr = S.toCharArray();
        dfs(arr,res,0,0,0);
        return res;
    }

    private static boolean dfs(char[] arr, List<Integer> res, int sum, int pre, int index) {
        if (index == arr.length){
            return res.size() > 3;
        }
        long currLong = 0;
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == '0') break;

            currLong = currLong * 10 + arr[index] - '0';
            if (currLong > Integer.MAX_VALUE) break;

            int cur = (int) currLong;
            if (res.size() >= 2){
                if (cur < sum){
                    continue;
                }else if (cur > sum){
                    break;
                }
            }
            res.add(cur);
            if(dfs(arr,res,pre + cur,cur,i + 1)){
                return true;
            }else {
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

}
