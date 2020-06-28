
/**
 * 合并两个有序链表
 * @date 2020/6/26 22:02
 */
public class MergeLinkList_21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特殊情况处理
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 递归调用
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}