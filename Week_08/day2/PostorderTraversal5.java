import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/29 0029 10:21
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostorderTraversal5 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pop();
            res.addFirst(cur.val);
            if (cur.left != null) deque.push(cur.left);
            if (cur.right != null) deque.push(cur.right);
        }
        return res;
    }

}
