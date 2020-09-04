/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/4 0004 14:23
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 */
public class IsBalanced {

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
        System.out.println(new IsBalanced().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return doIsBalanced(root) != -1;
    }

    private int doIsBalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = doIsBalanced(node.left);
        if(leftDepth == -1) return -1;
        int rightDepth = doIsBalanced(node.right);
        if(rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
