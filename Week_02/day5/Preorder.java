import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 21:33
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return doPreorder(list,root);
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        if (root == null) return list;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            Node cur = deque.pollFirst();
            list.add(cur.val);
            if (cur.children != null){
                for(int i = cur.children.size() - 1; i >= 0;i--){
                    deque.addFirst(cur.children.get(i));
                }
            }
        }
        return list;
    }

    public List<Integer> doPreorder(List<Integer> list, Node node) {
        if(node == null) return list;
        list.add(node.val);
        if (node.children != null){
            for(Node n : node.children){
                doPreorder(list,n);
            }
        }
        return list;
    }
}
