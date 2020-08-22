import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 第二遍
 */
public class Preorder2 {
    public static void main(String[] args) {

    }

    /**
     * 深度优先，使用栈实现
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            Node cur = deque.pollFirst();
            list.add(cur.val);
            if (cur.children != null){
                //先吧右节点压入栈，下一轮则先拿到左节点
                for (int i = cur.children.size() - 1; i >= 0 ; i--) {
                    deque.addFirst(cur.children.get(i));
                }
            }
        }
        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return doPreorder(list,root);
    }

    public List<Integer> doPreorder(List<Integer> list, Node node) {
        if (node == null) return list;
        list.add(node.val);
        for (Node n : node.children){
            doPreorder(list,n);
        }
        return list;
    }
}
