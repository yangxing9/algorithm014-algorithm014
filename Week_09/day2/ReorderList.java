import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/22 0022 15:07
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    public void reorderList2(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new LinkedList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int i = 0,j = list.size() - 1;
        ListNode dummy = new ListNode(-1);
        while (i < j){
            dummy.next = list.get(i++);
            dummy = dummy.next;
            dummy.next = list.get(j--);
            dummy = dummy.next;
        }
        if (i == j){
            ListNode last = list.get(i);
            dummy.next = last;
            dummy = dummy.next;
        }
        dummy.next = null;
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}
