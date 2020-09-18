import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/16 0016 10:18
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 */
public class InvertTree2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(new InvertTree2().invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            if (cur.left != null || cur.right != null){
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
            }
            if (cur.left != null) deque.offer(cur.left);
            if (cur.right != null) deque.offer(cur.right);
        }
        return root;
    }

}
