/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 10:40
 */
public class MinDepth3 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) return right + 1;
        else if (right == 0) return left + 1;
        return Math.min(left,right) + 1;
    }
}
