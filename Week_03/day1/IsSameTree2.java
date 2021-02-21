/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:32
 */
public class IsSameTree2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
