import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/16 0016 16:10
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res,root,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int index) {
        if (root == null) return;
        if (index == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        dfs(res,root.left,index + 1);
        dfs(res,root.right,index + 1);
    }
}
