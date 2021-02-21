/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:16
 */
public class InvertTree5 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }

}
