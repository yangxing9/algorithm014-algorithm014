/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:00
 */
public class IsSymmetric3 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }

}
