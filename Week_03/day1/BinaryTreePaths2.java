import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:43
 */
public class BinaryTreePaths2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        return dfs(res,root,root.val + "");
    }

    private List<String> dfs(List<String> res, TreeNode root,String str) {
        if (root.left == null && root.right == null){
            res.add(str);
            return res;
        }
        if (root.left != null){
            dfs(res,root.left,str + "->" + root.left.val);
        }
        if (root.right != null){
            dfs(res,root.right,str + "->" + root.right.val);
        }
        return res;
    }

}
