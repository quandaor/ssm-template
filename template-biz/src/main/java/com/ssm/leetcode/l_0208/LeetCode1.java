package com.ssm.leetcode.l_0208;

/**
 * @author quandaoran
 * @date 2020-02-08
 * @description 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * NULL->1->2->3->4->5
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1 {


    /**
     * 迭代法
     * <p>
     * 1.改变next的指向
     * 2.移动双指针的位置
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

//        上一个节点
        ListNode pre = null;
//        当前节点
        ListNode cur = head;
//          遍历当前元素
        while (cur != null) {
//            记录当前元素的下一个节点
            ListNode temp = cur.next;

//            使当前元素的指针指向上一个元素
            cur.next = pre;

//            改变双指针;
            pre = cur;

            cur = temp;
        }
        return pre;
    }


    /**
     * 递归实现
     */
    public ListNode reverseList1(ListNode head) {

//        递归终止条件
        if (head == null || head.next == null) {
            return head;
        }


//        最后一个节点
        ListNode cur = reverseList1(head.next);

        head.next.next = cur;


        return null;
    }

}


class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
