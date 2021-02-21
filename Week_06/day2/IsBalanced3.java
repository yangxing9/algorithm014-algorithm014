/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 10:29
 */
public class IsBalanced3 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        return Math.abs(right - left) > 1 ? -1 : Math.max(left,right) + 1;
    }

}
