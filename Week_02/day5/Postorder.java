import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 21:03
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return doPostorder(list,root);
    }

    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> list = new LinkedList();
        Deque<Node> deque = new ArrayDeque<>();
        if (root == null) return list;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            Node cur = deque.pollFirst();
            list.addFirst(cur.val);
            if (cur.children != null && cur.children.size() > 0){
                for(Node node : cur.children){
                    deque.addFirst(node);
                }
            }
        }
        return list;
    }

    public List<Integer> doPostorder(List<Integer> list,Node node) {
        if (node == null) return list;
        if (node.children != null){
            for (Node i : node.children) {
                doPostorder(list,i);
            }
        }
        list.add(node.val);
        return list;
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}