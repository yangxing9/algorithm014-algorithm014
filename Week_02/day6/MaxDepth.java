/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 17:46
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 从第0层开始
        return doMaxDepth(0,root);
    }

    public static int doMaxDepth(int maxDepth, TreeNode node){
        if (node == null) return maxDepth;
        // 到每层先自增
        maxDepth++;
        int left = doMaxDepth(maxDepth,node.left);
        int right = doMaxDepth(maxDepth,node.right);
        // 返回较大的层级
        return Math.max(left,right);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
