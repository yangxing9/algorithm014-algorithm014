/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/4 0004 15:05
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：
 */
public class MaxDepth3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n22 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n33 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n44 = new TreeNode(4);
        root.left = n2;
        root.right = n22;
        n2.left = n3;
        n2.right = n33;
        n3.left = n4;
        n3.right = n44;
        System.out.println(new MaxDepth3().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
