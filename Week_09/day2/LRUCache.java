import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/13 0013 13:43
 * 面试题 16.25. LRU缓存
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    private int capacity;
    private HashMap<Integer,LruListNode> map;
    private LruListNode head,tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new LruListNode(-1, -1);
        tail = new LruListNode(-1, -1);
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LruListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        removeToTail(node);
        return node.val;
    }

    private void removeToTail(LruListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            LruListNode node = map.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            removeToTail(node);
        }else {
            LruListNode node = new LruListNode(key,value);
            map.put(key,node);
            removeToTail(node);
            if (map.size() > capacity){
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }
    }

}
class LruListNode{
    int key;
    int val;
    LruListNode pre,next;
    public LruListNode(int key,int val){
        this.key = key;
        this.val = val;
    }

}