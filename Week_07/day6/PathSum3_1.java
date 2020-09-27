import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/27 0027 10:49
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSum3_1 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;
        System.out.println(new PathSum3_1().pathSum(a,8));
    }

    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pop();
            dfs(cur,sum);
            if (cur.left != null) deque.push(cur.left);
            if (cur.right != null) deque.push(cur.right);
        }
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        if (sum == node.val) res++;
        if (node.left == null && node.right == null) return;
        dfs(node.left,sum - node.val);
        dfs(node.right,sum - node.val);
    }

}
