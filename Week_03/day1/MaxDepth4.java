/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 10:39
 */
public class MaxDepth4 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right,left) + 1;
    }

}
