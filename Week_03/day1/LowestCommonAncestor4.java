import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 16:21
 */
public class LowestCommonAncestor4 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer,TreeNode> map = new HashMap<>();
        cache(root,map);
        Set<TreeNode> set = new HashSet<>();
        while (p != null){
            set.add(p);
            p = map.get(p.val);
        }
        while (q != null){
            if (set.contains(q)) return q;
            q = map.get(q.val);
        }
        return null;
    }

    private void cache(TreeNode root, Map<Integer, TreeNode> map) {
        if (root.left != null){
            map.put(root.left.val,root);
            cache(root.left,map);
        }
        if (root.right != null){
            map.put(root.right.val,root);
            cache(root.right,map);
        }
    }

}
