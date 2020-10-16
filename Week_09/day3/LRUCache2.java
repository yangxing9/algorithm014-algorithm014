import java.util.HashMap;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/14 0014 19:25
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache2 {

    private int capacity;
    private HashMap<Integer,LruNode> map;
    private LruNode head;
    private LruNode tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new LruNode(-1,-1);
        this.tail = new LruNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LruNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.value;
    }

    private void moveToTail(LruNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            LruNode node = map.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);
        }else {
            LruNode node = new LruNode(key,value);
            map.put(key,node);
            moveToTail(node);
            if (map.size() > capacity){
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }
    }
}
class LruNode{
    int key;
    int value;
    LruNode pre;
    LruNode next;
    public LruNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}