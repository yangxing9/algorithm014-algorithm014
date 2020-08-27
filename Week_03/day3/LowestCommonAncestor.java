import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/27 0027 11:19
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {

    /**
     * 思路：1. 缓存所有节点，将 左右子节点与 根节点绑定
     *      2. 从 p 开始向上遍历，缓存走过的节点
     *      3. 再从q 开始向上遍历，遇到 p 缓存过的节点 ，则表示遇到的即为 p，q共同的祖先
     *          因为都是从自己向上遍历的，所以第一个遇到的 肯定是 最近的祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer,TreeNode> cache = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        cacheRoot(root,cache);
        while (p != null){
            set.add(p.val);
            p = cache.get(p.val);
        }
        while (q != null){
            if (set.contains(q.val)){
                return q;
            }
            q = cache.get(q.val);
        }
        return null;
    }

    public void cacheRoot(TreeNode node,Map<Integer,TreeNode> cache){
        if (node.left != null) {
            cache.put(node.left.val,node);
            cacheRoot(node.left,cache);
        }
        if (node.right != null) {
            cache.put(node.right.val,node);
            cacheRoot(node.right,cache);
        }
    }

    /**
     * 最优解
     * 1. 遍历左右子树，如果遇到 p，q，则返回 p,q，如未遇到，则返回null，代表该分支没有目标
     * 2. 若 左右子树都为null，代表没有公共祖先
     * 3. 若左右子树都不为null，则说明 目标分部在当前节点的左右两侧，当前节点即为 最小公共祖先
     * 4. 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *      p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *      p,q两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     *
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return null;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
