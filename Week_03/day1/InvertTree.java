import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/24 0024 19:40
 * 226. 翻转二叉树
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
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(7);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(1);
        TreeNode left3 = new TreeNode(9);
        TreeNode right3 = new TreeNode(6);
        right1.left = left2;
        right1.right = right2;
        left1.left = left3;
        left1.right = right3;
        root.left = left1;
        root.right = right1;
        TreeNode result = invertTree(root);
        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pop();
            if (cur.left != null || cur.right != null){
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
            }
            if (cur.left != null) deque.push(cur.left);
            if (cur.right != null) deque.push(cur.right);
        }
        return root;
    }

}
