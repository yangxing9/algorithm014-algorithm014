import java.util.PriorityQueue;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/12 0012 14:51
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class MergeKLists2 {

    /**
     * 方案一：首尾合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int length = lists.length;
        while (length > 1){
            int start = 0,end = length - 1;
            while (start < end) {
                lists[start] = mergeTwoList(lists[start++],lists[end--]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    /**
     * 方案二：归并思想
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length - 1);
    }

    /**
     * 方案三：优先队列最小堆
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            ListNode min = queue.poll();
            cur.next = min;
            cur = cur.next;
            if (min.next != null){
                queue.offer(min.next);
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode l = merge(lists,start,mid);
        ListNode r = merge(lists,mid + 1,end);
        return mergeTwoList(l,r);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }

}
