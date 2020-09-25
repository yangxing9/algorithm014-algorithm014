import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/28 0028 10:16
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 */
public class IsSymmetric {

    /**
     * 事实证明 中序遍历，再判断回文是错误的做法
     *       3
     *      / \
     *    2   2
     *   /   /
     *  2   2
     *  比如这种，中序遍历 22122，是回文，但是不是对称
     */
    public boolean isSymmetric(TreeNode root) {
        List<Integer> inorder = inorderTraversal(root);
        return isPalindrome(inorder);
    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return doIsSymmetric2(root.left,root.right);
    }

    private boolean doIsSymmetric2(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && doIsSymmetric2(left.left,right.right)
                && doIsSymmetric2(left.right,right.left);
    }


    private boolean isPalindrome(List<Integer> list){
        if (list == null && list.size() == 0) return true;
        for(int i = 0,j = list.size() - 1; i <= j;i++,j--){
            if(list.get(i).intValue() != list.get(j).intValue()){
                return false;
            }
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return doInorderTraversal(list,root);
    }

    public List<Integer> doInorderTraversal(List<Integer> list ,TreeNode node){
        if (node == null) return list;
        doInorderTraversal(list,node.left);
        list.add(node.val);
        doInorderTraversal(list,node.right);
        return list;
    }
}
