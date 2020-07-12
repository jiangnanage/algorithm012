/**
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */
public class MergeTwoLists {

    /**
     * 迭代
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(-1);
        ListNode preNode = listNode;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;

            }else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return listNode.next;
    }

    /**
     * 递归
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
