/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *          0
 *        /  \
 *       2    4
 *     /    /  \
 *    1    3   -1
 *  / \     \    \
 * 5   1     6    8
 *
 * 返回5
 */
public class SumOfLeftLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

}
