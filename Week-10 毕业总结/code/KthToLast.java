/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/4 0004 15:52
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head,slow = head;
        int index = 0;
        while (fast != null){
            if (index >= k) slow = slow.next;
            fast = fast.next;
            index++;
        }
        return slow.val;
    }

}
