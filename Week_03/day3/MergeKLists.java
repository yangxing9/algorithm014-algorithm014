import java.util.PriorityQueue;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/26 0026 11:39
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
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
public class MergeKLists {

    public static void main(String[] args) {
        ReviewNode reviewNode = new ReviewNode(1);
        ReviewNode reviewNode2 = new ReviewNode(2);
        reviewNode.next = reviewNode2;
        ReviewNode node = new ReviewNode(1);
        ReviewNode node2 = new ReviewNode(2);
        reviewNode.next = reviewNode2;
        node.next = node2;
        ReviewNode result = mergeTwoLists(reviewNode,node);
        System.out.println();
    }

    public static ReviewNode mergeTwoLists(ReviewNode l1, ReviewNode l2) {
        ReviewNode dummy = new ReviewNode(-1);
        ReviewNode first = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                first.next = l1;
                l1 = l1.next;
            }else {
                first.next = l2;
                l2 = l2.next;
            }
            first = first.next;
        }
        first.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 思路：较为简单，循环，合并后的一直和 第 i 个合并
     */
    public ReviewNode mergeKLists(ReviewNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ReviewNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result,lists[i]);
        }
        return result;
    }

    /**
     * 归并 循环写法
     * 思路： 头尾对应合并，并将合并后的值赋值给前面一个，不断缩小length，直到length为 1
     *          如果是奇数个，那么中间的不管
     */
    public ReviewNode mergeKLists2(ReviewNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int length = lists.length;
        while (length > 1){
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoLists(lists[i],lists[length - i - 1]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    public ReviewNode mergeKLists3(ReviewNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        return doMergeKLists3(lists,0,lists.length-1);
    }

    public ReviewNode doMergeKLists3(ReviewNode[] lists,int left,int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ReviewNode l = doMergeKLists3(lists,left,mid);
        ReviewNode r = doMergeKLists3(lists,mid + 1,right);
        return mergeTwoLists(l,r);
    }

    /**
     * 最小堆实现
     */
    public ReviewNode mergeKLists4(ReviewNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        PriorityQueue<ReviewNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        ReviewNode dummy  = new ReviewNode(-1);
        ReviewNode pre = dummy;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }
        while (!queue.isEmpty()){
            ReviewNode cur = queue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null){
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }


}
