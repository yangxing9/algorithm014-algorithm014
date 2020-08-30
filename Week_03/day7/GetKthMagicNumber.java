import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class GetKthMagicNumber {
    public static void main(String[] args) {
        GetKthMagicNumber demo = new GetKthMagicNumber();
        System.out.println(demo.getKthMagicNumber2(3));
    }

    public int getKthMagicNumber(int k) {
        List<Integer> list = new ArrayList<>();
        if (k <= 0) return -1;
        list.add(1);
        return doGetKthMagicNumber(k,list,0,0,0);
    }

    private int doGetKthMagicNumber(int k,List<Integer> list,int treePoint,int fivePoint,int sevenPoint){
        if (list.size() == k){
            return list.get(k - 1);
        }
        int tree = list.get(treePoint) * 3;
        int five = list.get(fivePoint) * 5;
        int seven = list.get(sevenPoint) * 7;
        int min = Math.min(Math.min(tree,five),seven);
        if (min == tree) treePoint ++;
        if (min == five) fivePoint ++;
        if (min == seven) sevenPoint ++;
        list.add(min);
        return doGetKthMagicNumber(k,list,treePoint,fivePoint,sevenPoint);
    }

    public int getKthMagicNumber2(int k) {
        if (k <= 0) return -1;
        int[] dp = new int[k];
        int treePoint = 0,fivePoint = 0,sevenPoint = 0;
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            int tree = dp[treePoint] * 3;
            int five = dp[fivePoint] * 5;
            int seven = dp[sevenPoint] * 7;
            int min = Math.min(Math.min(tree,five),seven);
            if (min == tree) treePoint ++;
            if (min == five) fivePoint ++;
            if (min == seven) sevenPoint ++;
            dp[i] = min;
        }
        return dp[k - 1];
    }
}
