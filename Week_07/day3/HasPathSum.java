/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 17:09
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node4;
        System.out.println(new HasPathSum().hasPathSum(node,1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // 不能到底再判断sum是否为0，这样会导致不是叶子结点也算上
        if (root.right == null && root.left == null){
            return root.val == sum;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }


}
