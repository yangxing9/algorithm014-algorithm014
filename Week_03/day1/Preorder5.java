import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 11:07
 */
public class Preorder5 {

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            Node cur = deque.pop();
            res.add(cur.val);
            if (cur.children != null){
                for (int i = cur.children.size() - 1; i >= 0 ; i--) {
                    deque.push(cur.children.get(i));
                }
            }
        }
        return res;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res, Node root) {
        if (root == null) return;
        List<Node> nodes = root.children;
        res.add(root.val);
        for (Node node : nodes) {
            dfs(res,node);
        }
    }

}
