/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/12 0012 16:55
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates2 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == pre.val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
