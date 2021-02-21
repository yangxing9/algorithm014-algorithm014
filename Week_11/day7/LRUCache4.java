import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/21 0021 11:47
 */
public class LRUCache4 {

    private Map<Integer,LruNode2> cache;
    private int capacity;
    private LruNode2 head = new LruNode2(-1,-1);
    private LruNode2 tail = new LruNode2(-2,-2);

    public LRUCache4(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }else {
            LruNode2 node = cache.get(key);
            moveToTail(node);
            return node.value;
        }
    }

    private void moveToTail(LruNode2 node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            LruNode2 node = cache.get(key);
            node.value = value;
            moveToTail(node);
        }else {
            LruNode2 node = new LruNode2(key,value);
            node.pre = tail.pre;
            tail.pre.next = node;
            node.next = tail;
            tail.pre = node;
            cache.put(key,node);
            if (cache.size() > capacity){
                LruNode2 r = head.next;
                cache.remove(r.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }
    }

}

class LruNode2{
     LruNode2 next;
     LruNode2 pre;
     int key;
     int value;

    public LruNode2(int key,int value){
        this.key = key;
        this.value = value;
    }
}
