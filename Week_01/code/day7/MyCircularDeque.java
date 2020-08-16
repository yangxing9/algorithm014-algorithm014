package day7;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/16 0016 18:04
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 * 提示：
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 */
public class MyCircularDeque {

    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) return false;
        if (head == null){
            this.head = new ListNode(value);
            this.tail = head;
        }else {
            ListNode cur = new ListNode(value);
            cur.next = head;
            head = cur;
        }
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) return false;
        if (tail == null){
            this.tail = new ListNode(value);
            this.head = tail;
        }else {
            ListNode cur = new ListNode(value);
            tail.next = cur;
            tail = cur;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(head == null) return false;
        if (head == tail){
            tail = null;
        }
        head = head.next;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(tail == null) return false;
        if (head == tail){
            head = null;
            tail = null;
        }else {
            ListNode cur = head;
            ListNode pre = head;
            while (cur.next != null){
                pre = cur;
                cur = pre.next;
            }
            pre.next = null;
            tail = pre;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(head != null){
            return head.val;
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(tail != null){
            return tail.val;
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}