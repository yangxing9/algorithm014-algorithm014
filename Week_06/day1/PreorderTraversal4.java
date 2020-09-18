import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/14 0014 14:03
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal4 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return dfs(res,root);
    }

    private List<Integer> dfs(List<Integer> res, TreeNode node) {
        if (node == null) return res;
        res.add(node.val);
        dfs(res,node.left);
        dfs(res,node.right);
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            res.add(cur.val);
            if (cur.right != null) deque.push(cur.right);
            if (cur.left != null) deque.push(cur.left);
        }
        return res;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            res.add(cur.val);
            if (cur.children != null){
                for (int i = cur.children.size() - 1;i >= 0;i--) {
                    if (cur.children.get(i) != null){
                        deque.push(cur.children.get(i));
                    }
                }
            }
        }
        return res;
    }
}
