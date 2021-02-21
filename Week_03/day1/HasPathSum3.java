/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 15:51
 */
public class HasPathSum3 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }

}
