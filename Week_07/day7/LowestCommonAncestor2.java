import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/27 0027 13:58
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer,TreeNode> map = new HashMap<>();
        cacheMap(root,map);
        Set<Integer> set = new HashSet<>();
        while (p != null){
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null){
            if (set.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    public void cacheMap(TreeNode node,Map<Integer,TreeNode> cache){
        if (node.left != null) {
            cache.put(node.left.val,node);
            cacheMap(node.left,cache);
        }
        if (node.right != null) {
            cache.put(node.right.val,node);
            cacheMap(node.right,cache);
        }
    }

}
