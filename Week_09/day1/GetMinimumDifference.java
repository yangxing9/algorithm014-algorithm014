import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/12 0012 15:23
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class GetMinimumDifference {

    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root != null){
            dfs(root.left);
            if (pre >= 0) min = Math.min(min,root.val - pre);
            pre = root.val;
            dfs(root.right);
        }
    }


    public int getMinimumDifference2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs2(root,list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs2(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs2(root.left,list);
        list.add(root.val);
        dfs2(root.right,list);
    }

    public int getMinimumDifference3(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        int pre = -1;
        int min = Integer.MAX_VALUE;
        while (!deque.isEmpty() || cur != null){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            if (pre != -1) min = Math.min(min,cur.val - pre);
            pre = cur.val;
            cur = cur.right;
        }
        return min;
    }
}
