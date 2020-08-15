package day4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/13 0013 14:29
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class HasCycle {

    public static void main(String[] args) {

    }

    /**
     * 暴力法
     * hash
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Map cache = new HashMap();
        while (head != null){
            if (cache.containsKey(head)){
                return true;
            }
            cache.put(head,head);
            head = head.next;
        }
        return false;
    }

    /**
     * 暴力法
     * 快慢指针
     * 思路：慢指针每次一步，快指针每次两部，没环一切好说，快指针先到末尾，结束
     *      有环的话。则快指针一定先进环，如果慢指针在非环阶段没有遇到一样的节点，那么慢指针最终也会进环，两者速度差值为1，在一个环里面跑，那么一定会相遇
     * 复杂度分析：
     *       空间复杂度：使用了两个指针（快慢），复杂度为O（n)
     *       时间复杂度：
     *         (1)：没环的话，快指针先到末尾，也就是遍历一遍（实际快指针每次两步，只遍历一半），为 O（n）
     *         (2)：有环的话，非环部分假设为 k，慢指针在进入环之前，遍历 k 个元素 ；
     *             进入环之后，理论上最大快慢指针相遇只需要 两者距离/速度差，也就是最大为 环的长度 M 所以加起来也就是O（n）的复杂度
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
