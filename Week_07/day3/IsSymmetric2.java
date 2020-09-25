import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 16:36
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric2 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println(new IsSymmetric2().isSymmetric2(a));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)return true;
        if (left == null || right == null)return false;
        return left.val == right.val && dfs(left.left,right.right) && dfs(left.right,right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root.left);
        deque.push(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pop();
            TreeNode right = deque.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            deque.push(left.left);
            deque.push(right.right);
            deque.push(left.right);
            deque.push(right.left);
        }
        return true;
    }
}
