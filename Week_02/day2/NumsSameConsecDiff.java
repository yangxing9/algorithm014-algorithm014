import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/18 0018 11:43
 * 967. 连续差相同的数字
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 *
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 *
 * 你可以按任何顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 *
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 * 提示：
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
public class NumsSameConsecDiff {

    public static void main(String[] args) {
        int[] result = numsSameConsecDiff(2,0);
        System.out.println(Arrays.toString(result));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 1; i < N; i++) {
            // 使用新集合 承载 末尾差距为k 的 高阶数
            List<Integer> cc = new ArrayList<>();
            for (int c : list) {
                // 获取末尾数字，刚开始肯定都是从一位数起
                int lastIndex = c % 10;
                // 排除以0开头的数字，注意这里用的是c，不是末尾数字，当变成两位数后，末尾为0也过滤不掉。如果加上K不超过10，则代表加上k后的数字满足条件
                if(c != 0 && lastIndex + K < 10){
                    // 原数 * 10，代表进一位，加上末尾数字，相当于原数*10，再加上K
                    cc.add(c * 10 + lastIndex + K);
                }
                // 多加了个 k != 0，入参k>=0 ，此时主要是为了，满足k=0的情况，加0和减0实际是一样的
                if(c != 0 && K != 0 && lastIndex - K >= 0){
                    cc.add(c * 10 + lastIndex - K);
                }
            }
            // 关键的一步，重置list，把第二位数字符合的，再次遍历，获取第三位符合的数字
            list = cc;
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
