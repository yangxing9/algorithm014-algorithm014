import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum2_1 {

    public static void main(String[] args) {
        PathSum2_1 demo = new PathSum2_1();
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;
        System.out.println(demo.pathSum(a,5));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        return dfs(res,root,sum,new ArrayList<Integer>());
    }

    private List<List<Integer>> dfs(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val){
                res.add(new ArrayList<>(list));
            }
            return res;
        }
        if (root.left != null) {
            dfs(res,root.left,sum - root.val,list);
            list.remove(list.size() - 1);
        }
        if (root.right != null){
            dfs(res,root.right,sum - root.val,list);
            list.remove(list.size() - 1);
        }
        return res;
    }
}
