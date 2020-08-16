package day7;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/16 0016 18:35
 */
public class Test {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(4); // 设置容量大小为3
        boolean x = circularDeque.insertFront(9);			        // 返回 true
        boolean z = circularDeque.deleteLast();
        int a = circularDeque.getRear();
        int b = circularDeque.getFront();
        int c = circularDeque.getFront();
        boolean m = circularDeque.deleteFront();
        boolean p = circularDeque.insertFront(6);			        // 返回 true
        boolean v = circularDeque.insertLast(5);			        // 返回 true
        boolean w = circularDeque.insertFront(6);			        // 返回 true
        circularDeque.insertFront(9);			        // 已经满了，返回 false
        int d = circularDeque.getFront();  				// 返回 2
        boolean q = circularDeque.insertFront(6);			        // 返回 true
    }
}
