import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/24 0024 17:18
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode right = new TreeNode(1);
        root.right = right;
        System.out.println(isValidBST2(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        double last = - Double.MAX_VALUE;
        int curNum = root.val;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while(cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            if (cur.val <= last) return false;
            last = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        return helper(root,null,null);
    }

    private static boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int cur = root.val;
        if (lower != null && cur <= lower) return false;
        if (upper != null && cur >= upper) return false;

        if(!helper(root.left,lower,cur)) return false;
        if(!helper(root.right,cur,upper)) return false;
        return true;
    }
}
