/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:40
 *
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) return 0;
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
    }

}
