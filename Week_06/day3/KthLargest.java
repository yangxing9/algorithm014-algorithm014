import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/16 0016 18:53
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class KthLargest {

    int count = 0;
    int ans = 0;
    public int kthLargest2(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }

    private void dfs( TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right,k);
        if (++count == k) {
            ans = root.val;
            return;
        }
        dfs(root.left,k);
    }

    public int kthLargest(TreeNode root, int k) {
        int count = 0;
        int ans = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null){
                deque.push(cur);
                cur = cur.right;
            }
            cur = deque.pop();
            if (++count == k) {
                ans = cur.val;
                break;
            }
            cur = cur.left;
        }
        return ans;
    }

}
