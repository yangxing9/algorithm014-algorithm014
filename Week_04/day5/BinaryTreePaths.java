import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/4 0004 13:58
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths demp = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> res = demp.binaryTreePaths(root);
        System.out.println(res);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        return doBinaryTreePaths(root,res,root.val + "");
    }

    private List<String> doBinaryTreePaths(TreeNode node, List<String> res, String curStr) {
        if (node.left == null && node.right == null){
            res.add(curStr);
            return res;
        }
        if (node.left != null){
            doBinaryTreePaths(node.left,res,curStr + "->" + node.left.val);
        }
        if (node.right != null){
            doBinaryTreePaths(node.right,res,curStr + "->" + node.right.val);
        }
        return res;
    }
}
